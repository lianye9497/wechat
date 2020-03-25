package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description: 小程序登陆
 * @author: 苏定
 * @create: 2019-07-10 14:32
 **/
@Data
public class JsCode2SessionResponse extends WxResponse {

    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "session_key")
    private String sessionKey;
}