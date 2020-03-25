package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @description: 小程序域名信息
 * @author: 苏定
 * @create: 2019-07-03 10:59
 **/
@Data
public class MiniProgramNetwork {

    @JSONField(name = "RequestDomain")
    private List<String> requestDomain;

    @JSONField(name = "WsRequestDomain")
    private List<String> wsRequestDomain;

    @JSONField(name = "UploadDomain")
    private List<String> uploadDomain;

    @JSONField(name = "DownloadDomain")
    private List<String> downloadDomain;
}