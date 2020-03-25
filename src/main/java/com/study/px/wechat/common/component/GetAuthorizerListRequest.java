package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-02 19:53
 **/
@Data
public class GetAuthorizerListRequest extends WxRequest<GetAuthorizerListResponse> {
    private String api = ProgramConstants.API_GET_AUTHORIZER_LIST;

    @JSONField(name = "component_appid")
    private String componentAppid;

    private Integer offset;

    private Integer count;
}