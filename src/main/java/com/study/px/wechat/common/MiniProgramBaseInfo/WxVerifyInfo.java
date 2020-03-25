package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class WxVerifyInfo {
    @JSONField(name = "qualification_verify")
    private Integer qualificationVerify;

    @JSONField(name = "naming_verify")
    private Integer namingVerify;

    @JSONField(name = "annual_review")
    private Integer annualReview;

    @JSONField(name = "annual_review_begin_time")
    private Integer annualReviewBeginTime;

    @JSONField(name = "annual_review_end_time")
    private Integer annualReviewEndTime;
}
