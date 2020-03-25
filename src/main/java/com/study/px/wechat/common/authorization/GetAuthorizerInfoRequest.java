package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-02 20:14
 **/
@Data
public class GetAuthorizerInfoRequest extends WxRequest<GetAuthorizerInfoResponse> {

    private String api = ProgramConstants.API_GET_AUTHORIZER_INFO;

    //第三方平台 appid
    @JSONField(name = "component_appid")
    private String componentAppid;

    //授权方 appid
    @JSONField(name = "authorizer_appid")
    private String authorizerAppid;


}