package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:微信审核推送枚举
 * @author: 苏定
 * @create: 2019-07-13 18:05
 **/
@Getter
@AllArgsConstructor
public enum WxAuditNoticeEnum {
    SUCCESS("weapp_audit_success"), FAIL("weapp_audit_fail");
    private String type;
}