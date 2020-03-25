package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * 小程序基本信息response
 */
@Data
public class MiniProgramBaseInfoResponse extends WxResponse {
    @JSONField(name="appid")
    private String appId;

    @JSONField(name="account_type")
    private Integer accountType;

    @JSONField(name="principal_type")
    private Integer principalType;

    @JSONField(name="principal_name")
    private String principalName;

    @JSONField(name="realname_status")
    private Integer realnameStatus;

    @JSONField(name="wx_verify_info")
    private WxVerifyInfo wxVerifyInfo;

    @JSONField(name="signature_info")
    private SignatureInfo signatureInfo;


    @JSONField(name="head_image_info")
    private HeadImageInfo headImageInfo;
}
