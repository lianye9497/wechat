package com.study.px.wechat.common.category;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryAuditInfo implements Serializable {
    @JSONField(name = "first")
    private String first;

    @JSONField(name = "first_name")
    private String firstName;

    @JSONField(name = "second")
    private String second;

    @JSONField(name = "second_name")
    private String secondName;

    @JSONField(name = "audit_status")
    private String auditStatus;

    @JSONField(name = "audit_reason")
    private String auditReason;
}
