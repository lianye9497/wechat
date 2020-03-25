package com.study.px.wechat.common.enums;

import lombok.Getter;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-03 16:20
 **/
@Getter
public enum AuthorizationNoticeTypeEnum {
    UNAUTHORIZED("unauthorized", "取消授权"), UPDATE_AUTHORIZED("updateauthorized", "更新授权"), AUTHORIZED("authorized", "授权成功"),
    COMPONENT_VERIFY_TICKET("component_verify_ticket", "票据");

    private String type;

    private String desc;

    AuthorizationNoticeTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}