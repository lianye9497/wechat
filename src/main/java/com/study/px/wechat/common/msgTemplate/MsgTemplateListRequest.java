package com.study.px.wechat.common.msgTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;

@Data
public class MsgTemplateListRequest extends WxRequest<MsgTemplateListResponse> {
    private String api;
    @JSONField(name = "offset")
    private Integer offset;
    @JSONField(name = "count")
    private Integer count;
}
