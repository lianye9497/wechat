package com.study.px.wechat.exception;

/**
 * @author wuyazi
 * @date 2020/02/11 18:00
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String msg) {
        super(msg);
    }
}
