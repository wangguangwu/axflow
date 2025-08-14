package com.axflow.application.validator;

import com.axflow.application.dto.ValidationResult;

/**
 * @author wangguangwu
 */
public interface TenantCaseSignValidator<T> {

    boolean supports(String tenantId);

    ValidationResult validate(T request);

}
