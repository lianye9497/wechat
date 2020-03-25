package com.study.px.wechat.constants;


/**
 * 异常枚举值
 */
public enum ExceptionErrorCode {

    /**
     * 参数类错误：10001-19999
     */
    PARA_INVALID(10001, "参数无效"), PARA_NULL(10002, "参数为空"), PARA_TYPE_ERROR(10003, "参数类型错误"), PARA_MISS(10004, "参数缺失"),
    /**
     * 用户类错误：20001-29999
     */
    USER_UNLOGIN(20001, "用户未登录"), USER_TOKEN_INVALID(20002, "token失效"),
    /**
     * 业务类错误：30001-39999
     */
    BIZ_(30001, "某业务出现错误"),
    BIZ_SMALL_APP_NOT_AUTHORIZATION(30002, "小程序为授权"),
    /**
     * 三方类错误：40001-49999
     */
    THIRD_SYSTEM_ERROR(40001, "系统繁忙，请稍后重试"),
    /**
     * 服务类错误：50001-59999
     */
    INTERNAL_SERVICE_ERROR(50001, "内部服务调用异常"), EXTERNAL_SERVICE_ERROR(50002, "外部服务调用异常"),
    /**
     * 流控类错误：60001-69999
     */
    IN_PROGRESS(60002, "正在访问中"),

    INTERFACE_FORBIDDEN_VISIT(60001, "该接口禁止访问"),
    // INTERFACE_URL_INVALID(60002,"接口地址无效"),
    INTERFACE_URL_INVALID(60003, "接口地址无效"), INTERFACE_REQUEST_TIMEOUT(60004, "接口请求超时"), INTERFACE_OVERLOAD(60005,
            "接口负载过高"),
    /**
     * 权限类错误：70001-79999 (常用于对外服务API)
     */
    NO_PERMISSION(70001, "无权访问"),;

    private Integer errorCode;

    private String errorMsg;

    ExceptionErrorCode(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public Integer getErrorCode() {
        return errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

}
