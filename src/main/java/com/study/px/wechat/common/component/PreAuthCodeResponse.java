package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 14:07
 **/
@Data
public class PreAuthCodeResponse extends WxResponse {

    @JSONField(name = "pre_auth_code")
    private String preAuthCode;
}