package com.study.px.wechat.common.authorization;

import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description: 体验二维码
 * @author: 苏定
 * @create: 2019-07-08 17:44
 **/
@Data
public class QrCodeResponse extends WxResponse {

    private String qrCodeUrl;
}