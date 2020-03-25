package com.study.px.wechat.common.component;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-02 19:53
 **/
@Data
public class GetAuthorizerListResponse extends WxResponse {
    //授权的帐号总数
    @JSONField(name = "total_count")
    private int totalCount;

    private List<AuthorizerRefreshToken> list;

}