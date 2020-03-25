package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @description: 小程序配置信息
 * @author: 苏定
 * @create: 2019-07-03 10:19
 **/
@Data
public class MiniProgramConfInfo {

    //小程序配置的合法域名信息
   private MiniProgramNetwork network;

   //小程序配置的类目信息
   private List<JSONObject> categories;

}