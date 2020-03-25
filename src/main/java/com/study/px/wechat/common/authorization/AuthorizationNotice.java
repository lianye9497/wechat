package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description: 授权通知
 * @author: 苏定
 * @create: 2019-07-03 16:34
 **/
@Data
public class AuthorizationNotice {

    //第三方平台 appid
    @JSONField(name = "AppId")
    private String appId;

    //时间戳
    @JSONField(name = "CreateTime")
    private Integer createTime;

    //通知类型
    @JSONField(name = "InfoType")
    private String infoType;

    //公众号或小程序的 appid
    @JSONField(name = "AuthorizerAppid")
    private String authorizerAppId;

    //授权码
    @JSONField(name = "AuthorizationCode")
    private String authorizationCode;

    //授权码过期时间 单位秒
    @JSONField(name = "AuthorizationCodeExpiredTime")
    private Integer authorizationCodeExpiredTime;

    //预授权码
    @JSONField(name = "PreAuthCode")
    private String preAuthCode;
}