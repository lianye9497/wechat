package com.study.px.wechat.common.member;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * 用户管理绑定Response
 */
@Data
public class BindTesterResponse extends WxResponse {
    @JSONField(name="userstr")
    private String userStr;
}
