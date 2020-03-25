package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description: 小程序授权账号信息
 * @author: 苏定
 * @create: 2019-07-02 20:14
 **/
@Data
public class GetAuthorizerInfoResponse extends WxResponse {

    //小程序帐号信息
    @JSONField(name = "authorizer_info")
    private Authorizer authorizerInfo;

    //授权信息
    @JSONField(name = "authorization_info")
    private AuthorizationInfo authorizationInfo;
}