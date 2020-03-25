package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description: 上传代码到小程序
 * @author: 苏定
 * @create: 2019-07-01 17:45
 **/
@Data
public class UploadCodeRequest extends WxRequest<UploadCodeResponse> {

    private String api = ProgramConstants.CODE_COMMIT;

    //代码库中的代码模版 ID
    @JSONField(name = "template_id")
    private String templateId;

    //第三方自定义的配置
    @JSONField(name = "ext_json")
    private String extJson;

    //代码版本号，开发者可自定义（长度不要超过 64 个字符）
    @JSONField(name = "user_version")
    private String userVersion;

    //代码描述，开发者可自定义
    @JSONField(name = "user_desc")
    private String userDesc;

}