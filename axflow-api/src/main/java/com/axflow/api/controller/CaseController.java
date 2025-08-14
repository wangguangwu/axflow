package com.axflow.api.controller;

import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.CaseSignRequest;
import com.axflow.application.dto.response.ApiResponse;
import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.application.validator.TenantCaseSignValidator;
import com.axflow.common.tenant.TenantContext;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 案件处理 controller
 *
 * @author wangguangwu
 */
@RequestMapping("/case")
@RestController
@RequiredArgsConstructor
public class CaseController {

    private final ClaimSignUseCase claimSignUseCase;

    private final List<? extends TenantCaseSignValidator<?>> validators;

    /**
     * 案件签收
     *
     * @param request 签收请求
     * @return 签收号
     */
    @PostMapping("/sign")
    public ApiResponse<String> sign(@RequestBody @Validated CaseSignRequest request) {
        @SuppressWarnings("unchecked")
        TenantCaseSignValidator<CaseSignRequest> validator = (TenantCaseSignValidator<CaseSignRequest>) validators.stream()
                .filter(v -> v.supports(TenantContext.getTenantId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("不支持的租户"));

        // 2. 执行校验
        ValidationResult result = validator.validate(request);
        if (!result.isValid()) {
            throw new IllegalArgumentException(String.join(",", result.getErrors()));
        }
        return ApiResponse.success(claimSignUseCase.claimSign(request));
    }
}
