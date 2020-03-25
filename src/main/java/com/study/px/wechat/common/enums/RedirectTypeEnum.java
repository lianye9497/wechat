package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-11 15:57
 **/
@Getter
@AllArgsConstructor
public enum RedirectTypeEnum {

    AUTHORIZED("authorized", "授权"), AUDIT("audit", "审核"), UNAUTHORIZED("unauthorized", "取消授权");

    private String type;

    private String desc;


}
