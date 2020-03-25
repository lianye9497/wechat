package com.study.px.wechat.common.msg;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @description:发送模板消息
 * @author: 苏定
 * @create: 2019-07-06 15:59
 **/
@Data
public class TemplateMsgSendRequest extends WxRequest<TemplateMsgSendResponse> {

    @JSONField(name="access_token")
    private String accessToken;//		是	接口调用凭证

    @JSONField(name="touser")
    private String toUser;//		是	接收者（用户）的 openid

    @JSONField(name="template_id")
    private String templateId;//		是	所需下发的模板消息的id

    private String page;//		否	点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转。

    @JSONField(name="form_id")
    private String formId;//		是	表单提交场景下，为 submit 事件带上的 formId；支付场景下，为本次支付的 prepay_id

    //模版数据，发送的接口用  TemplateConstant
    private Map<String, TemplateData> data;

    @JSONField(name="emphasis_keyword")
    private String emphasisKeyword;//		否	模板需要放大的关键词，不填则默认无放大

    @Data
    @NoArgsConstructor
    public static class TemplateData implements Serializable {
        private String value;
        private String color;

        public TemplateData(String color, String value) {
            this.color = color;
            this.value = value;
        }
    }

}