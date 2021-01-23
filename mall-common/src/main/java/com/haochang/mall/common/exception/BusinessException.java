package com.haochang.mall.common.exception;
/**
 * @Description 描述：统一异常处理
 * @Author: youzhi.gao
 * @Date: 2021-01-20 10:50
 */
public class BusinessException extends Exception {

    public BusinessException(){super();}

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
