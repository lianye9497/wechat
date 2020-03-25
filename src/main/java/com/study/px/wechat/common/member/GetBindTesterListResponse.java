package com.study.px.wechat.common.member;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * 用户管理绑定Response
 */
@Data
public class GetBindTesterListResponse extends WxResponse {
    @JSONField(name = "members")
    private List<Members> members;
}
