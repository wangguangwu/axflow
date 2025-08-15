package com.axflow.api.handler;

import com.axflow.application.dto.response.ApiResponse;
import com.axflow.common.enums.ResponseStatusEnum;
import com.axflow.common.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

/**
 * 全局异常处理器
 *
 * @author wangguangwu
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ================= 业务异常处理 =================
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleBusinessException(BusinessException e,
                                                     HttpServletRequest request) {
        log.error("业务异常 [{}] {} - {}",
                request.getMethod(),
                request.getRequestURI(), e.getMessage(), e);
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }

    // ================= 系统级异常 =================
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleSystemException(Exception e,
                                                   HttpServletRequest request) {
        log.error("系统异常 [ID: [{}] {} - ",
                request.getMethod(),
                request.getRequestURI(),
                e);
        return ApiResponse.fail(ResponseStatusEnum.FAILED.getCode(), "执行错误: " + e.getMessage());
    }
}

