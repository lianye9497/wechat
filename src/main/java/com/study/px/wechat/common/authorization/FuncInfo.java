package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-05-24 17:33
 **/
@Data
public class FuncInfo {

    @JSONField(name = "funcscope_category")
    private FuncscopeCategory funcscopeCategory;
}
