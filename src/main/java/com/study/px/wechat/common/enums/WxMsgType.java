package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:微信消息类型
 * @author: 苏定
 * @create: 2019-07-13 12:00
 **/
@Getter
@AllArgsConstructor
public enum WxMsgType {

    TEXT("text", "文本消息"), IMAGE("image", "图片消息"), LINK("link", "图文链接"), MINI_PROGRAM("miniprogrampage", "小程序卡片");

    private String type;

    private String desc;

}
