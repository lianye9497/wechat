package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * 小程序设置名称改名request
 */
@Data
public class MiniProgramNickNameRequest extends WxRequest<MiniProgramNickNameResponse> {
    private String api;

    @JSONField(name = "nick_name")
    private String nickName;

    @JSONField(name = "id_card")
    private String idCard;

    @JSONField(name = "license")
    private String license;

    @JSONField(name = "naming_other_stuff_1")
    private String namingOtherStuff1;

    @JSONField(name = "naming_other_stuff_2")
    private String namingOtherStuff2;
}
