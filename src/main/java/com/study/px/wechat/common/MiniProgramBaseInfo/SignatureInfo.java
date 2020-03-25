package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class SignatureInfo {
    @JSONField(name = "signature")
    private String signature;

    @JSONField(name = "modify_used_count")
    private Integer modifyUsedCount;

    @JSONField(name = "modify_quota")
    private Integer modifyQuota;
}
