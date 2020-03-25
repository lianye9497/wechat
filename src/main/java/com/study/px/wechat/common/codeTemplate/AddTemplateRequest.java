package com.study.px.wechat.common.codeTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

@Data
public class AddTemplateRequest extends WxRequest<AddTemplateResponse> {

    @JSONField(name = "draft_id")
    private String draftId;
}
