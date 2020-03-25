package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;


/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 10:59
 **/
@Data
public class ComponentAccessTokenRequest extends WxRequest<ComponentAccessTokenResponse> {

    private String api = ProgramConstants.API_COMPONENT_TOKEN;

    @JSONField(name = "component_appid")
    private String componentAppid;

    @JSONField(name = "component_appsecret")
    private String componentAppsecret;

    @JSONField(name = "component_verify_ticket")
    private String componentVerifyTicket;
}