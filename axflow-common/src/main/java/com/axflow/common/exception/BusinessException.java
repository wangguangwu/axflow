package com.axflow.common.exception;

import lombok.Getter;

/**
 * 自定义业务异常
 *
 * @author wangguangwu
 */
@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

}
