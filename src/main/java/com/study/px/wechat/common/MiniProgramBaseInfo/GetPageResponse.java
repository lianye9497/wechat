package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

import java.util.List;

/**
 * @description: 获取小程序页面配置
 * @author: 苏定
 * @create: 2019-07-04 18:50
 **/
@Data
public class GetPageResponse extends WxResponse {

    @JSONField(name = "page_list")
    private List<String> pageList;

}