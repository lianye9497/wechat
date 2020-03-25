package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-05 14:13
 **/
@Data
public class GetLastAuditStatusResponse extends WxResponse {

    @JSONField(name = "auditid")
    private String auditId;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "reason")
    private String reason;

    @JSONField(name = "ScreenShot")
    private String screenShot;

}