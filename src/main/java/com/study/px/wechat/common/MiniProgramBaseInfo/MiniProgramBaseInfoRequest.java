package com.study.px.wechat.common.MiniProgramBaseInfo;


import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * 小程序基本信息request
 */
@Data
public class MiniProgramBaseInfoRequest extends WxRequest<MiniProgramBaseInfoResponse> {
    private String api = ProgramConstants.GET_ACCOUNT_BASIC_INFO;
}
