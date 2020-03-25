package com.study.px.wechat.common.category;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-11 14:55
 **/
@Data
public class Category implements Serializable {

    //类目 ID
    @JSONField(name = "id")
    private String id;

    //类目名称
    private String name;

    //类目层级
    private String level;

    //类目父级 ID
    private String father;

    //子级类目 ID
    private String children;

    //是否为敏感类目（1 为敏感类目，需要提供相应资质审核；0 为非敏感类目，无需审核）
    @JSONField(name = "sensitive_type")
    private String sensitiveType;

    //sensitive_type 为 1 的类目需要提供的资质证明
    @JSONField(name = "qualify.exter_list")
    private List<QualifyExter> exterList;
}