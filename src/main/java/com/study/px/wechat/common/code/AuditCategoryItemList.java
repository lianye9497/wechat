package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-05 10:44
 **/
@Data
public class AuditCategoryItemList implements Serializable {

    //是	小程序的页面，可通过获取小程序的页面列表接口获得
    @JSONField(name = "address")
    private String address;

    //否	小程序的标签，用空格分隔，标签至多 10 个，标签长度至多 20
    @JSONField(name = "tag")
    private String tag;

    //是	一级类目名称
    @JSONField(name = "first_class")
    private String firstClass;

    //是	二级类目名称
    @JSONField(name = "second_class")
    private String secondClass;

    //否	三级类目名称
    @JSONField(name = "third_class")
    private String thirdClass;

    //是	一级类目的 ID
    @JSONField(name = "first_id")
    private String firstId;

    //是	二级类目的 ID
    @JSONField(name = "second_id")
    private String secondId;

    //否 三级类目的 ID
    @JSONField(name = "third_id")
    private String thirdId;

    //是 小程序页面的标题,标题长度至多 32
    @JSONField(name = "title")
    private String title;


}