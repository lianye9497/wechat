package com.study.px.wechat.common.category;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * 用小程序获取类目response
 */
@Data
public class MiniProgramGetCategoryResponse extends WxResponse {

    @JSONField(name = "categories")
    private List<CategoryAuditInfo> categories;

    @JSONField(name = "limit")
    private Integer limit;

    @JSONField(name = "quota")
    private Integer quota;

    @JSONField(name = "category_limit")
    private Integer categoryLimit;

}
