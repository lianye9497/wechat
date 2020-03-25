package com.study.px.wechat.common.category;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-11 14:57
 **/
@Data
public class QualifyExter implements Serializable {

    @JSONField(name = "exter_list")
    private List<JSONObject> exterList;

    private String remark;
}