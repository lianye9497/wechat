package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-03 11:05
 **/
@Data
public class AuthorizerRefreshToken {

    //已授权的 appid
    @JSONField(name = "authorizer_appid")
    private String authorizerAppId;

    //刷新令牌
    @JSONField(name = "refresh_token")
    private String refreshToken;

    //授权的时间
    @JSONField(name = "auth_time")
    private String authTime;
}