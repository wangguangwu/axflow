package com.axflow.common.exception;

import com.axflow.common.enums.ApiResponseStatusEnum;
import lombok.Getter;

/**
 * 通用业务异常基类
 *
 * @author wangguangwu
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 业务错误码
     */
    private final int code;

    public BaseException(String message) {
        super(message);
        this.code = ApiResponseStatusEnum.FAILED.getCode();
    }

    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
