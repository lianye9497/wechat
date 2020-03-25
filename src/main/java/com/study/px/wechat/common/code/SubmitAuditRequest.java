package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxRequest;
import com.study.px.wechat.common.constants.ProgramConstants;
import lombok.Data;

import java.util.List;

/**
 * @description: 上传代码到小程序
 * @author: 苏定
 * @create: 2019-07-01 17:45
 **/
@Data
public class SubmitAuditRequest extends WxRequest<SubmitAuditResponse> {

    private String api = ProgramConstants.SUBMIT_AUDIT;

    //审核项列表（至少填写 1 项，至多填写 5 项）
    @JSONField(name = "item_list")
    private List<AuditCategoryItemList> itemList;

    //反馈内容，至多 200 字
    @JSONField(name = "feedback_info")
    private String feedbackInfo;

    //用 | 分割的 media_id 列表，至多 5 张图片, 可以通过新增临时素材接口上传而得到
    @JSONField(name = "feedback_stuff")
    private String feedbackStuff;

}