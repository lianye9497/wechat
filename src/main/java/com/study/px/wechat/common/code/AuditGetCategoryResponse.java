package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @description: 获取审核时可填写的类目信息
 * @author: 苏定
 * @create: 2019-07-05 13:45
 **/
@Data
public class AuditGetCategoryResponse extends WxResponse {

    @JSONField(name = "category_list")
    private List<AuditCategoryItemList> categoryList;
}