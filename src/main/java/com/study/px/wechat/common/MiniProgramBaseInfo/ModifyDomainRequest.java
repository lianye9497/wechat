package com.study.px.wechat.common.MiniProgramBaseInfo;


import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description: 设置小程序域名
 * @author: 苏定
 * @create: 2019-07-02 17:06
 **/
@Data
public class ModifyDomainRequest extends WxRequest<ModifyDomainResponse> {

    private String api = ProgramConstants.MODIFY_DOMAIN;

    private String action;

    private String[] requestdomain;

    private String[] wsrequestdomain;

    private String[] uploaddomain;

    private String[] downloaddomain;

}