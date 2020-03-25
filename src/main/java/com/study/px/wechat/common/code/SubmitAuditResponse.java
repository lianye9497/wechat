package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-01 17:46
 **/
@Data
public class SubmitAuditResponse extends WxResponse {

    //审核编号
    @JSONField(name = "auditid")
    private String auditId;
}