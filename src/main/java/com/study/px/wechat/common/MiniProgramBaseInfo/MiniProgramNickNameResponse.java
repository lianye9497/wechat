package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * 小程序基本信息response
 */
@Data
public class MiniProgramNickNameResponse extends WxResponse {
    @JSONField(name = "wording")
    private String wording;

    @JSONField(name = "audit_id")
    private String auditId;
}
