package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * 小程序修改功能介绍request
 */
@Data
public class MiniProgramModifySignatureRequest extends WxRequest<MiniProgramModifySignatureResponse> {
    private String api;

    @JSONField(name = "signature")
    private String signature;
}
