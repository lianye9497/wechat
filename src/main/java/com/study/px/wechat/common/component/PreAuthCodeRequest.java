package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 14:07
 **/
@Data
public class PreAuthCodeRequest extends WxRequest<PreAuthCodeResponse> {

    private String api = ProgramConstants.PRE_AUTH_CODE_URL;

    private boolean needComponentAccessToken = true;

    @JSONField(name = "component_appid")
    private String componentAppid;

}