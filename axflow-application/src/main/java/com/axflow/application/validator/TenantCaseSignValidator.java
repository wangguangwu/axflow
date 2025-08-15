package com.axflow.application.validator;

import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.CaseSignRequest;

/**
 * @author wangguangwu
 */
public interface TenantCaseSignValidator<T extends CaseSignRequest> {

    /**
     * 是否租户支持
     *
     * @param tenantId 租户id
     * @return boolean
     */
    boolean supports(String tenantId);

    /**
     * 声明目标 DTO 类型
     *
     * @return 目标 DTO 类型
     */
    Class<T> targetType();

    /**
     * 执行校验
     *
     * @param request 请求
     * @return 校验结果
     */
    ValidationResult validate(T request);

}
