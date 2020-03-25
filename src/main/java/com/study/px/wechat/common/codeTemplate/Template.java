package com.study.px.wechat.common.codeTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Template {
    @JSONField(name = "create_time")
    private long createTime;
    @JSONField(name = "user_version")
    private String userVersion;
    @JSONField(name = "user_desc")
    private String userDesc;
    @JSONField(name = "template_id")
    private String templateId;
    @JSONField(name = "source_miniprogram")
    private String sourceMiniprogram;
    @JSONField(name = "developer")
    private String developer;
    @JSONField(name = "source_miniprogram_appid")
    private String sourceMiniprogramAppId;
}
