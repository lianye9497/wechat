package com.study.px.wechat.common.member;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * 用户管理绑定request
 */
@Data
public class BindTesterRequest extends WxRequest<BindTesterResponse> {
    private String api;

    @JSONField(name = "wechatid")
    private String wechatId;
}
