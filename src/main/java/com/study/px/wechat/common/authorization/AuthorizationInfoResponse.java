package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-06-27 14:46
 **/
@Data
public class AuthorizationInfoResponse extends WxResponse {

    @JSONField(name = "authorization_info")
    private AuthorizationInfo authorizationInfo;
}