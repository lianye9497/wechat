package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description: 授权信息
 * @author: 苏定
 * @create: 2019-05-24 17:33
 **/
@Data
public class AuthorizationInfo {

    @JSONField(name = "authorizer_appid")
    private String authorizerAppId;

    @JSONField(name = "authorizer_access_token")
    private String authorizerAccessToken;

    @JSONField(name = "authorizer_refresh_token")
    private String authorizerRefreshToken;

    @JSONField(name = "func_info")
    private List<FuncInfo> funcInfos;

    @JSONField(name = "expires_in")
    private Integer expiresIn;

}
