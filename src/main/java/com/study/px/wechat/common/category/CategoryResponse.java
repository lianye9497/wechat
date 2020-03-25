package com.study.px.wechat.common.category;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-11 15:07
 **/
@Data
public class CategoryResponse extends WxResponse {

    @JSONField(name = "categories_list")
    private List<Category> categories;
}