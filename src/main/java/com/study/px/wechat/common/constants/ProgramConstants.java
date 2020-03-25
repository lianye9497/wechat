package com.study.px.wechat.common.constants;

/**
 * @description: 小程序相关 信息
 * @author: 苏定
 * @create: 2019-05-23 20:16
 **/
public final class ProgramConstants {

    public static final String WX_API_DOMAIN = "https://api.weixin.qq.com";
    public static final String WX_API_PREFIX = "";

    //获取预授权码pre_auth_code
    public static final String PRE_AUTH_CODE_URL = "/cgi-bin/component/api_create_preauthcode?component_access_token=%s";
    //获取component_token
    public static final String API_COMPONENT_TOKEN = "/cgi-bin/component/api_component_token";
    //小程序授权链接
    public static final String AUTH_URL = "https://mp.weixin.qq.com/safe/bindcomponent?action=bindcomponent&auth_type=3&no_scan=1&component_appid=%s&pre_auth_code=%s&redirect_uri=%s";
    //小程序扫码授权链接
    public static final String QR_CODE_AUTH_URL = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=%s&pre_auth_code=%s&redirect_uri=%s&auth_type=3";

    //获取小程序授权TOKEN authorizer_access_token
    public static final String AUTHORIZE_ACCESS_TOKEN = "/cgi-bin/component/api_query_auth?component_access_token=%s";
    //刷新access-token
    public static final String REFRESH_ACCESS_TOKEN = "/cgi-bin/component/api_authorizer_token?component_access_token=%s";

    //拉取所有已授权的帐号信息
    public static final String API_GET_AUTHORIZER_LIST = "/cgi-bin/component/api_get_authorizer_list?component_access_token=%s";

    //auth.code2Session
    public static final String JS_CODE2_SESSION ="/sns/component/jscode2session?appid=%s&js_code=%s&grant_type=authorization_code&component_appid=%s&component_access_token=%s";

    /****************小程序信息设置*************************/

    //获取授权方的帐号基本信息
    public static final String API_GET_AUTHORIZER_INFO = "/cgi-bin/component/api_get_authorizer_info?component_access_token=%s";

    //获取小程序基本信息
    public static final String GET_ACCOUNT_BASIC_INFO = "/cgi-bin/account/getaccountbasicinfo?access_token=%s";

    //设置服务器域名
    public static final String MODIFY_DOMAIN = "/wxa/modify_domain?access_token=%s";

    //小程序名称设置及改名
    public static final String SETNICK_NAME = "/wxa/setnickname?access_token=%s";

    //小程序改名审核状态查询
    public static final String API_WXA_QUERYNICKNAME = "/wxa/api_wxa_querynickname?access_token=%s";

    //微信认证名称检测
    public static final String CHECK_WX_VERIFY_NICKNAME = "/cgi-bin/wxverify/checkwxverifynickname?access_token=%s";

    //修改头像
    public static final String MODIFY_HEADIMAGE = "/cgi-bin/account/modifyheadimage?access_token=%s";

    //修改功能介绍
    public static final String MODIFY_SIGNATURE = "/cgi-bin/account/modifysignature?access_token=%s";

    //换绑小程序管理员

    /**************** 小程序基础信息设置********************/
    //设置小程序是否可以被搜索
    public static final String CHANGE_WX_SEARCH_STATUS = "/wxa/changewxasearchstatus?access_token=%s";
    //查询小程序是否可以被搜索状态
    public static final String GET_WXA_SEARCH_STATUS = "/wxa/getwxasearchstatus?access_token=%s";
    //获取展示的公众号信息(用户扫码小程序时展示)
    public static final String GET_SHOW_WXA_ITEM = "/wxa/getshowwxaitem?access_token=%s";
    //设置展示的公众号
    public static final String UPDATE_SHOW_WXA_ITEM = "/wxa/updateshowwxaitem?access_token=%s";
    //获取可以用来设置的公众号列表
    public static final String GET_WXA_MPLINK_FOR_SHOW = "/wxa/getwxamplinkforshow?access_token=%s";

    /*****************成员管理****************************/
    //绑定微信用户为小程序体验者
    public static final String BIND_TESTER = "/wxa/bind_tester?access_token=%s";
    //解除小程序体验者的绑定
    public static final String UNBIND_TESTER = "/wxa/unbind_tester?access_token=%s";
    //获取体验者列表
    public static final String MEMBER_AUTH = "/wxa/memberauth?access_token=%s";

    /*****************类目管理****************************/

    //获取可以设置的所有类目
    public static final String GET_ALL_CATEGORIES = "/cgi-bin/wxopen/getallcategories?access_token=%s";

    //获取已设置的所有类目
    public static final String GET_CATEGORY ="/cgi-bin/wxopen/getcategory?access_token=%s";

    //获取审核时可填写的类目信息
    public static final String CODE_GET_CATEGORY = "/wxa/get_category?access_token=%s";

    //添加类目
    public static final String ADD_CATEGORY = "/cgi-bin/wxopen/addcategory?access_token=%s";

    //删除类目
    public static final String DELETE_CATEGORY = "/cgi-bin/wxopen/deletecategory?access_token=%s";

    //修改类目信息
    public static final String MODIFY_CATEGORY = "/cgi-bin/wxopen/modifycategory?access_token=%s";

    /*****************代码管理****************************/

    //上传代码
    public static final String CODE_COMMIT = "/wxa/commit?access_token=%s";

    //获取已上传的代码的页面列表
    public static final String GET_PAGE ="/wxa/get_page?access_token=%s";

    //获取体验小程序的体验二维码
    public static final String GET_QRCODE = "/wxa/get_qrcode?access_token=%s&path=%s";

    //提交审核
    public static final String SUBMIT_AUDIT = "/wxa/submit_audit?access_token=%s";

    //查询指定发布审核单的审核状态
    public static final String GET_AUDIT_STATUS = "/wxa/get_auditstatus?access_token=%s";

    //查询最新一次提交的审核状态
    public static final String GET_LATEST_AUDIT_STATUS = "/wxa/get_latest_auditstatus?access_token=%s";

    //小程序审核撤回
    public static final String UNDO_CODE_AUDIT = "/wxa/undocodeaudit?access_token=%s";

    //发布已通过审核的小程序
    public static final String RELEASE = "/wxa/release?access_token=%s";

    //版本回退
    public static final String REVERT_CODE_RELEASE = "wxa/revertcoderelease?access_token=%s";

    public static final String QR_CODE_PATH_PREFIX = "miniprogram/qrcode";



    /*****************代码模板库管理****************************/

    //获取草稿箱内的所有临时代码草稿
    public static final String GET_TEMPLATE_DRAFT_LIST = "/wxa/gettemplatedraftlist?access_token=%s";
    //获取代码模版库中的所有小程序代码模版
    public static final String GET_TEMPLATE_LIST = "/wxa/gettemplatelist?access_token=%s";
    //将草稿箱的草稿选为小程序代码模版
    public static final String ADD_TEMPLATE = "/wxa/addtotemplate?access_token=%s";
    //删除指定小程序代码模版
    public static final String DELETED_TEMPLATE = "/wxa/deletetemplate?access_token=%s";

    /*****************小程序模板消息设置管理****************************/
    //获取小程序消息模板列表
    public static final String MSG_TEMPLATE_LIST = "/cgi-bin/wxopen/template/list?access_token=%s";

    //发送模板消息
    public static final String TEMPLATE_SEND = "/cgi-bin/message/wxopen/template/send?access_token=%s";

    //临时素材上传
    public static final String TEMP_MATERIAL = "/cgi-bin/media/upload?access_token=%s&type=image";

    //发送客服消息
    public static final String CUSTOM_SEND ="/cgi-bin/message/custom/send?access_token=%s";


}
