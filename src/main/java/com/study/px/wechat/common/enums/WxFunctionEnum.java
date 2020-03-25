package com.study.px.wechat.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author: 苏定
 * @create: 2019-07-16 16:01
 **/
@Getter
@AllArgsConstructor
public enum WxFunctionEnum {

    MESSAGE_MANAGE(1,"消息管理权限"),USER_MANAGE(2,"用户管理权限"),ACCOUNT_SERVICE(3,"帐号服务权限"),
    WEB_PAGE(4,"网页服务权限"),WX_SMALL_STORE(5,"微信小店权限"),WXD_CUSTOMER_SERVICE( 6,"微信多客服权限"),
    GROUP_MSG_NOTICE(7,"群发与通知权限"),WX_CARD( 8,"微信卡券权限"),WX_SCAN(9,"微信扫一扫权限"),
    WX_WIFI(10,"微信连WIFI权限"),MEDIA_MANAGE(11,"素材管理权限"),WXY_AROUND(12,"微信摇周边权限"),
    WX_STORE(13,"微信门店权限"),MENU(15,"自定义菜单权限"),AUTHENTICATION(16,"获取认证状态及信息"),
    ACCOUNT_MANAGE_SMALL_APP(17,"帐号管理权限（小程序）"),DEVELOPMENT_MANAGE(18,"开发管理与数据分析权限（小程序）"),
    CUSTOMER_MSG_MANAGE(19,"客服消息管理权限（小程序）"),WX_LOGIN(20,"微信登录权限（小程序）"),
    DATA_ANALYSIS_SMALL_APP(21,"数据分析权限（小程序）"),CITY_SERVICE(22,"城市服务接口权限"),
    AD_MANAGE(23,"广告管理权限"),OPEN_PLATFORM_ACCOUNT_MANAGE(24,"开放平台帐号管理权限"),
    ELECTRONIC_INVOICE(26,"微信电子发票权限"),SEARCH_WIDGET(41,"搜索widget的权限")
    ;
    private Integer code;

    private String desc;

    public boolean hasFunction(Integer code){
        if (code == null){
            return false;
        }
        WxFunctionEnum anEnum = getEnum(code);
        if (anEnum == null){
            return false;
        }
        if (this.code.equals(code)){
            return true;
        }
        return false;
    }
    public static WxFunctionEnum getEnum(Integer code) {
        for (WxFunctionEnum dealEnum : WxFunctionEnum.values()) {
            if (dealEnum.getCode().equals(code)) {
                return dealEnum;
            }
        }
        return null;
    }

}