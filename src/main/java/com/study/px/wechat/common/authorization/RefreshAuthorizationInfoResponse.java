package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.Date;

/**
 * @description: 刷新小程序授权
 * @author: 苏定
 * @create: 2019-07-03 11:21
 **/
@Data
public class RefreshAuthorizationInfoResponse extends WxResponse {
    private String authorizerAppId;

    @JSONField(name = "authorizer_access_token")
    private String authorizerAccessToken;

    @JSONField(name = "expires_in")
    private Integer expiresIn;

    private Date createTime;

    @JSONField(name = "authorizer_refresh_token")
    private String authorizerRefreshToken;

}