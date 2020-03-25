package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 09:43
 **/
@Data
public class AuthorizationInfoRequest extends WxRequest<AuthorizationInfoResponse> {

    private String api = ProgramConstants.AUTHORIZE_ACCESS_TOKEN;

    @JSONField(name = "component_appid")
    private String componentAppid;

    @JSONField(name = "authorization_code")
    private String authorizationCode;

}