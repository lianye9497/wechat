package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-01 19:27
 **/
@Data
public class GetAuditStatusRequest extends WxRequest<GetAuditStatusResponse> {

    private String api = ProgramConstants.GET_AUDIT_STATUS;

    @JSONField(name = "auditid")
    private String auditId;
}