package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:审核状态
 * @author: 苏定
 * @create: 2019-07-12 11:49
 **/
@Getter
@AllArgsConstructor
public enum AuditCodeStatusEnum {

    SUCCESS(0, "审核成功"), FAIL(1, "审核失败"), IN_PROGRESS(2, "审核中"), UNDO(3, "撤回");
    private Integer code;

    private String desc;

    public static AuditCodeStatusEnum getEnum(Integer code) {
        for (AuditCodeStatusEnum dealEnum : AuditCodeStatusEnum.values()) {
            if (dealEnum.getCode().equals(code)) {
                return dealEnum;
            }
        }
        return null;
    }

}