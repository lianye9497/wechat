package com.study.px.wechat.common.codeTemplate;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetTemplatedListResponse extends WxResponse {
    @JSONField(name = "template_list")
    private List<Template> templateList;
}
