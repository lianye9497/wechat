package com.study.px.wechat.common.msgTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class MsgTemplateList {

    @JSONField(name="template_id")
    private String templateId;

    @JSONField(name="title")
    private String title;

    @JSONField(name="content")
    private String content;

    @JSONField(name="example")
    private String example;
}
