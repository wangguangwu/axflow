package com.axflow.common.exception;

/**
 * @author wangguangwu
 */
public class CompanyBException extends BaseException {

    public CompanyBException(String message) {
        super(message);
    }

    public CompanyBException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
