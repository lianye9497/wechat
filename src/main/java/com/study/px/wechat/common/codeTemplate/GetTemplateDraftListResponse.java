package com.study.px.wechat.common.codeTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetTemplateDraftListResponse extends WxResponse {
    @JSONField(name = "draft_list")
    private List<Draft> draftList;
}
