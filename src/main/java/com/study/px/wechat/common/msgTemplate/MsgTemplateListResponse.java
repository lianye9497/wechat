package com.study.px.wechat.common.msgTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

@Data
public class MsgTemplateListResponse extends WxResponse {
    @JSONField(name="list")
    private List<MsgTemplateList> list;
}
