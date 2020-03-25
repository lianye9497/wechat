package com.study.px.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.WxResponse;
import com.study.px.wechat.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.study.px.wechat.common.constants.ProgramConstants.WX_API_DOMAIN;


/**
 * @description: 微信请求类
 * @author: 苏定
 * @create: 2019-06-27 10:33
 **/
@Slf4j
public class WxClient {

    private WxClient() {
    }

    public static byte[] executeGetForByte(String url) {
        return OkHttpUtil.requestForByteGet(WX_API_DOMAIN + url, null, null, null);
    }

    public static <T extends WxResponse> T executePost(WxRequest<T> request) {
        Map<String, Object> params = getParam(request);
        if (StringUtils.isNotBlank(request.getComponentAccessToken())) {
            request.setApi(String.format(request.getApi(), request.getComponentAccessToken()));
        }
        String json = OkHttpUtil.requestOfPost(WX_API_DOMAIN + request.getApi(), params);
        return dealResult(request, json);
    }

    public static <T extends WxResponse> T executeFormPost(WxRequest<T> request, MultipartFile file) {
        Map<String, Object> params = getParam(request);
        if (StringUtils.isNotBlank(request.getComponentAccessToken())) {
            request.setApi(String.format(request.getApi(), request.getComponentAccessToken()));
        }
        String json = OkHttpUtil.requestOfFormPost(WX_API_DOMAIN + request.getApi(), params, file);
        return dealResult(request, json);
    }


    public static <T extends WxResponse> T executeGet(WxRequest<T> request) {
        Map<String, Object> params = getParam(request);
        String url = request.getApi();
        if (StringUtils.isNotBlank(request.getComponentAccessToken())) {
            url = String.format(request.getApi(), request.getComponentAccessToken());
        }
        String json = OkHttpUtil.requestOfGet(WX_API_DOMAIN + url, null, params);
        return dealResult(request, json);
    }


    public static <T extends WxResponse> T dealResult(WxRequest<T> request, String json) {
        T result = JSON.parseObject(json, request.getResponseClass());
        if (result == null) {
            log.error("请求{}失败,原因={},参数={}", request.getApi(), json, request);
            return failResponse(request.getResponseClass());
        }
        if (result.getErrCode() != null && result.getErrCode() != 0) {
            log.error("请求{}失败,原因={},参数={}", request.getApi(), json, request);
//            if (WxErrorCodeEnum.ACCESS_TOKEN_EXPIRED.getCode().equals(result.getErrCode())) {
//                //这里的appId 不是百分百准确，请注意
//                String appId = WxRequestContentUtil.getRequestAppId();
//                RobotUtil.sendAlarm("token超时导致调用接口失败appId=" + appId);
//                log.error("请求appId={},url={}失败,原因={},参数={}", appId, request.getApi(), json, request);
//            }
            return result;
        }
        log.info("请求{}结果={}", request.getApi(), json);
        result.setSuccess(true);
        return result;
    }

    private static <T extends WxResponse> Map<String, Object> getParam(WxRequest<T> request) {
        Map<String, Object> params = new HashMap<>();
        Field[] declaredFields = request.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            JSONField annotation = field.getAnnotation(JSONField.class);
            String name = annotation == null ? field.getName() : annotation.name();
            if ("api".equals(name) || "needComponentAccessToken".equals(name)) continue;
            try {
                Object value = null;
                Object o = field.get(request);
                if (o == null) continue;
//                if (o.getClass().isArray()) {
//                    value = JSON.toJSONString(o);
//                } else if (o instanceof List) {
//                    value = o;
//                } else {
//                    value = String.valueOf(o);
//                }
                value = o;
                params.put(name, value);
            } catch (IllegalAccessException e) {
                log.info("获取字段属性失败");
            }
        }
        return params;
    }

    private static <T extends WxResponse> T failResponse(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BusinessException("pdd接口请求异常");
        }
    }
}