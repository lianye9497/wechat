package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-02 17:06
 **/
@Data
public class ModifyDomainResponse extends WxResponse {


    private List<String> requestdomain;

    private List<String> wsrequestdomain;

    private List<String> uploaddomain;

    private List<String> downloaddomain;

}