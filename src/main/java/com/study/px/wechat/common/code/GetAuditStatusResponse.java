package com.study.px.wechat.common.code;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.WxResponse;
import lombok.Data;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-01 19:27
 **/
@Data
public class GetAuditStatusResponse extends WxResponse {

    //0	审核成功
    //1	审核被拒绝
    //2	审核中
    //3	已撤回
    @JSONField(name = "status")
    private String status;

    //当审核被拒绝时，返回的拒绝原因
    @JSONField(name = "reason")
    private String reason;

    //当审核被拒绝时，会返回审核失败的小程序截图示例。用 | 分隔的 media_id 的列表，可通过获取永久素材接口拉取截图内容
    @JSONField(name = "screenshot")
    private String screenshot;
}