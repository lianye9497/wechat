package com.study.px.wechat.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @description:微信请求上下文工具类
 * @author: 苏定
 * @create: 2019-07-19 14:30
 **/
@Slf4j
public class WxRequestContentUtil {

    private WxRequestContentUtil() {
    }

    private static final ThreadLocal<WxRequestContent> REQUEST_CONTENT_CACHE = new ThreadLocal<>();

    public static void init(WxRequestContent requestContent) {
        try {
            REQUEST_CONTENT_CACHE.remove();
            REQUEST_CONTENT_CACHE.set(requestContent);
        } catch (Exception e) {
            log.info("设置微信请求缓存失败e={}", e);
        }
    }

    public static void init(String appId) {
        if (StringUtils.isBlank(appId)) {
            return;
        }
        try {
            REQUEST_CONTENT_CACHE.remove();
            WxRequestContent requestContent = new WxRequestContent();
            requestContent.setAppId(appId);
            REQUEST_CONTENT_CACHE.set(requestContent);
        } catch (Exception e) {
            log.info("设置微信请求缓存失败e={}", e);
        }
    }

    public static WxRequestContent getRequestContent() {
        return REQUEST_CONTENT_CACHE.get();
    }

    public static String getRequestAppId() {
        WxRequestContent requestContent = REQUEST_CONTENT_CACHE.get();
        if (requestContent == null) {
            return "1";
        }
        return requestContent.getAppId();
    }
}