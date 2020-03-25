package com.study.px.wechat.common.authorization;

import com.alibaba.fastjson.annotation.JSONField;
import com.study.px.wechat.common.MiniProgramBaseInfo.BusinessInfo;
import com.study.px.wechat.common.MiniProgramBaseInfo.MiniProgramConfInfo;
import com.study.px.wechat.common.MiniProgramBaseInfo.ServiceTypeInfo;
import com.study.px.wechat.common.MiniProgramBaseInfo.VerifyTypeInfo;
import lombok.Data;

/**
 * @description: 小程序账号信息
 * @author: 苏定
 * @create: 2019-07-03 10:11
 **/
@Data
public class Authorizer {

    //昵称
    @JSONField(name = "nick_name")
    private String nickName;

    //头像
    @JSONField(name = "head_img")
    private String headImg;

    //默认为 0
    @JSONField(name = "service_type_info")
    private ServiceTypeInfo serviceTypeInfo;

    //小程序认证类型-1	未认证 0	 微信认证
    @JSONField(name = "verify_type_info")
    private VerifyTypeInfo verifyTypeInfo;

    //原始 ID
    @JSONField(name = "user_name")
    private String userName;

    //主体名称
    @JSONField(name = "principal_name")
    private String principalName;

    //帐号介绍
    @JSONField(name = "signature")
    private String signature;

    //用以了解功能的开通状况（0代表未开通，1代表已开通）
    @JSONField(name = "business_info")
    private BusinessInfo businessInfo;

    //二维码图片的 URL，开发者最好自行也进行保存
    @JSONField(name = "qrcode_url")
    private String qrcodeUrl;

    //小程序配置，根据这个字段判断是否为小程序类型授权
    private MiniProgramConfInfo miniprograminfo;
}