package com.study.px.wechat.common.code;

import com.study.px.wechat.common.WxRequest;
import lombok.Data;

/**
 * @description: 查询最新一次提交的审核状态
 * @author: 苏定
 * @create: 2019-07-05 14:14
 **/
@Data
public class GetLastAuditStatusRequest extends WxRequest<GetLastAuditStatusResponse> {
}