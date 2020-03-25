package com.study.px.wechat.common.code;

import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description: 二维码
 * @author: 苏定
 * @create: 2019-07-02 15:51
 **/
@Data
public class GetQrCodeRequest extends WxRequest<GetQrcodeResponse> {
    private String api = ProgramConstants.GET_QRCODE;

    private String path;

    private boolean isUploadOss = true;
}