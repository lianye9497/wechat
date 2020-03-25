package com.study.px.wechat.common.MiniProgramBaseInfo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @description: 小程序功能信息
 * @author: 苏定
 * @create: 2019-07-03 10:25
 **/
@Data
public class BusinessInfo {
    //是否开通微信门店功能
    @JSONField(name = "open_store")
    private String openStore;
    //	是否开通微信扫商品功能
    @JSONField(name = "open_scan")
    private String openScan;
    //是否开通微信支付功能
    @JSONField(name = "open_pay")
    private String openPay;
    //是否开通微信卡券功能
    @JSONField(name = "open_card")
    private String openCard;
    //是否开通微信摇一摇功能
    @JSONField(name = "open_shake")
    private String openShake;

}