package com.study.px.wechat.common.member;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * 用户管理解绑request
 */
@Data
public class UnBindTesterRequest extends WxRequest<UnBindTesterResponse> {
    private String api;

    @JSONField(name = "wechatid")
    private String wechatId;
}
