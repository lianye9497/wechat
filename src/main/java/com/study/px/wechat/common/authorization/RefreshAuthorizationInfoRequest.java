package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description: 刷新小程序授权
 * @author: 苏定
 * @create: 2019-06-27 15:06
 **/
@Data
public class RefreshAuthorizationInfoRequest extends WxRequest<RefreshAuthorizationInfoResponse> {

    private String api = ProgramConstants.REFRESH_ACCESS_TOKEN;

    @JSONField(name = "component_appid")
    private String componentAppid;

    @JSONField(name = "authorizer_appid")
    private String authorizerAppid;

    @JSONField(name = "authorizer_refresh_token")
    private String authorizerRefreshToken;

}