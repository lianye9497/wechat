package com.study.px.wechat.common.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class Members {
    @JSONField(name = "userstr")
    private String userStr;
}
