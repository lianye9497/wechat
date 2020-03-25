package com.study.px.wechat.common.authorization;

import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-09 19:28
 **/
@Data
public class AuthUrlResponse extends WxResponse {

    /**
     * 授权链接
     */
    private String authUrl;
}