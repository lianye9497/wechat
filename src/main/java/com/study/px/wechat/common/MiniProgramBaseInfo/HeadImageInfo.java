package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class HeadImageInfo {
    @JSONField(name = "head_image_url")
    private String headImageUrl;

    @JSONField(name = "modify_used_count")
    private Integer modifyUsedCount;

    @JSONField(name = "modify_quota")
    private Integer modifyQuota;

}
