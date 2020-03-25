package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 10:59
 **/
@Data
public class ComponentAccessTokenResponse extends WxResponse {

    @JSONField(name = "component_access_token")
    private String componentAccessToken;
}