package com.axflow.common.exception;

/**
 * @author wangguangwu
 */
public class CompanyAException extends BaseException {

    public CompanyAException(String message) {
        super(message);
    }

    public CompanyAException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
