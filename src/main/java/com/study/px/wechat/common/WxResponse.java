package com.study.px.wechat.common;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 微信基础返回
 * @author: 苏定
 * @create: 2019-06-26 19:15
 **/
@Data
public class WxResponse implements Serializable {

    @JSONField(name = "errcode")
    private Integer errCode;

    @JSONField(name = "errmsg")
    private String errMsg;

    @JSONField(name = "expires_in")
    private Integer expiresIn;

    private boolean isSuccess;
}