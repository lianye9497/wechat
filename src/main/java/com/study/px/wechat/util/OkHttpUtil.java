package com.study.px.wechat.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * http工具类
 *
 * @author suding
 * @date 2018-04-16
 */
@Slf4j
public class OkHttpUtil {


    private OkHttpUtil() {
    }

    /**
     * 处理url，拼接token和时间戳
     *
     * @param url
     * @return
     */
    private static String handleUrl(String url, Map<String, Object> urlParams) {
        if (urlParams == null || urlParams.isEmpty()) {
            return url;
        }
        if (url.lastIndexOf("?") == -1) {
            url = url + "?";
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        for (Map.Entry<String, Object> entry : urlParams.entrySet()) {
            String v = (String) entry.getValue();
            if (v.lastIndexOf(";") != -1) {
                v = v.substring(0, v.lastIndexOf(";"));
            }
            urlBuilder.append("&").append(entry.getKey()).append("=").append(v);
        }
        url = urlBuilder.toString();
        return url;
    }

    private static OkHttpClient getClient(Long timeout) {
        if (timeout == null) {
            timeout = 5000L;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS);
        return builder.build();
    }

    /**
     * get请求
     *
     * @return
     */
    public static String requestOfGet(String url, Map<String, String> headers, Map<String, Object> urlParams) {
        return requestOfGet(url, headers, urlParams, 5000L);
    }

    /**
     * get请求
     *
     * @param timeout 超时时间，单位毫秒
     * @return
     */
    public static String requestOfGet(String url, Map<String, String> headers, Map<String, Object> urlParams, Long timeout) {
        url = handleUrl(url, urlParams);
        Request request = getRequest(url, null, headers);
        ResponseBody responseBody = doConnection(timeout, request);
        if (responseBody != null) {
            try {
                return responseBody.string();
            } catch (IOException e) {
                log.error("IOException={}", e);
            }
        }
        return null;
    }

    public static byte[] requestForByteGet(String url, Map<String, String> headers, Map<String, Object> urlParams, Long timeout) {
        url = handleUrl(url, urlParams);
        Request request = getRequest(url, null, headers);
        ResponseBody responseBody = doConnection(timeout, request);
        if (responseBody != null) {
            try {
                return responseBody.bytes();
            } catch (IOException e) {
                log.error("IOException={}", e);
            }
        }
        return null;
    }

    /**
     * 获取最终的请求对象
     *
     * @param url
     * @param requestBody
     * @return
     */
    private static Request getRequest(String url, RequestBody requestBody, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder().url(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
        builder.addHeader("Connection", "keep-alive");
        if (requestBody != null) {
            builder.post(requestBody);
        }
        return builder.build();
    }

    /**
     * 执行post 返回string
     *
     * @param url
     * @param jsonObject
     * @return
     */
    public static String requestOfPost(String url, Object jsonObject) {
        ResponseBody responseBody = requestPost(url, jsonObject);
        if (responseBody != null) {
            try {
                return responseBody.string();
            } catch (IOException e) {
                log.error("IOException={}", e);
            }
        }
        return null;
    }

    /**
     * 执行post 返回byte
     *
     * @param url
     * @param urlParams
     * @return
     */
    public static byte[] requestByteOfPost(String url, Object urlParams) {
        ResponseBody responseBody = requestPost(url, urlParams);
        if (responseBody != null) {
            try {
                return responseBody.bytes();
            } catch (IOException e) {
                log.error("OkHttpUtil.requestOfPost请求异常：", e);
            }
        }
        return null;
    }

    /**
     * 执行post 返回 ResponseBody
     *
     * @param url
     * @param urlParams
     * @return
     */
    private static ResponseBody requestPost(String url, Object urlParams) {
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(urlParams));
        Request request = getRequest(url, body, null);
        return doConnection(null, request);
    }

    /**
     * 表单 请求
     *
     * @param url
     * @param urlParams
     * @param file
     * @return
     */
    public static String requestOfFormPost(String url, Map<String, Object> urlParams, MultipartFile file) {
        ResponseBody responseBody = requestFormPost(url, urlParams, file);
        if (responseBody != null) {
            try {
                return responseBody.string();
            } catch (IOException e) {
                log.error("IOException={}", e);
            }
        }
        return null;
    }

    private static ResponseBody requestFormPost(String url, Map<String, Object> urlParams, MultipartFile file) {
        RequestBody multiBody = createWxFileRequestBody(urlParams, file);
        Request request = getRequest(url, multiBody, null);
        return doConnection(null, request);
    }

    /**
     * 创建微信文件上传RequestBody
     * @param urlParams
     * @param file
     * @return
     */
    private static RequestBody createWxFileRequestBody(Map<String, Object> urlParams, MultipartFile file) {
        try {
            RequestBody fileBody = MultipartBody.create(MediaType.parse(file.getContentType()), file.getBytes());
            MultipartBody.Builder multiBuilder = new MultipartBody.Builder();
            // 设置请求体
            multiBuilder.setType(MultipartBody.FORM);
            //这里是 封装上传图片参数
            multiBuilder.addFormDataPart("media", file.getOriginalFilename(), fileBody);

//        multiBuilder.addFormDataPart("filelength", String.valueOf(file.getSize()));
//        multiBuilder.addFormDataPart("filename", file.getOriginalFilename());
//        multiBuilder.addFormDataPart("content-type", file.getContentType());
            //参数以添加header方式将参数封装，否则上传参数为空
            if (urlParams != null) {
                for (String key2 : urlParams.keySet()) {
                    multiBuilder.addFormDataPart(key2, (String) urlParams.get(key2));
                }
            }
            return multiBuilder.build();
        } catch (IOException e) {
            log.error("获取文件流异常");
        }
        return null;
    }

    private static ResponseBody doConnection(Long timeout, Request request) {
        try {
            OkHttpClient client = getClient(timeout);
            Response response = client.newCall(request).execute();
            if (response.code() == 200) {
                return response.body();
            }
        } catch (IOException e) {
            log.error("OkHttpUtil.requestOfPost请求异常：", e);
        }
        return null;
    }

}
