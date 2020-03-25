package com.study.px.wechat.common;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 09:41
 **/
@Data
public class WxRequest<T extends WxResponse> implements Serializable {

    private String api;

    private String componentAccessToken;

    private String accessToken;

    public Class<T> getResponseClass() {
        return (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}