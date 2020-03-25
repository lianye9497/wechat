package com.study.px.wechat.common.code;

import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-02 15:51
 **/
@Data
public class GetQrcodeResponse extends WxResponse {

    //二进制数据
    private byte[] bytes;

    //上传后的oss路径
    private String ossUrl;
}