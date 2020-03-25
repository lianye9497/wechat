package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 微信错误枚举
 * @author: 苏定
 * @create: 2019-07-18 16:43
 **/
@Getter
@AllArgsConstructor
public enum WxErrorCodeEnum {
    ACCESS_TOKEN_EXPIRED(42001, "token超时");
    private Integer code;

    private String desc;
}