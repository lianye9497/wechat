package com.study.px.wechat.common.codeTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

@Data
public class DeleteTemplateRequest extends WxRequest<DeleteTemplateResponse> {

    @JSONField(name = "template_id")
    private String templateId;
}
