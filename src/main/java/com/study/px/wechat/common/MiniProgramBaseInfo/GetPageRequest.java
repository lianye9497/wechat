package com.study.px.wechat.common.MiniProgramBaseInfo;


import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

/**
 * @description: 获取小程序页面配置
 * @author: 苏定
 * @create: 2019-07-04 18:51
 **/
@Data
public class GetPageRequest extends WxRequest<GetPageResponse> {
    private String api = ProgramConstants.GET_PAGE;
}