package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * @description:小程序登陆
 * @author: 苏定
 * @create: 2019-07-10 14:38
 **/
@Data
public class JsCode2SessionRequest extends WxRequest<JsCode2SessionResponse> {

    @JSONField(name = "appid")
    private String appId;

    @JSONField(name = "js_code")
    private String jsCode;

    @JSONField(name = "grant_type")
    private String grantType;

    @JSONField(name = "component_appid")
    private String componentAppId;

    @JSONField(name = "component_access_token")
    private String componentAccessToken;
}