package com.axflow.api.controller;

import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.CaseSignRequest;
import com.axflow.application.dto.response.ApiResponse;
import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.application.validator.TenantCaseSignValidator;
import com.axflow.common.tenant.TenantContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    private final ObjectMapper objectMapper;
    private final List<? extends TenantCaseSignValidator<?>> validators;

    /**
     * 案件签收
     *
     * @return 签收号
     */
    @PostMapping("/sign")
    public ApiResponse<String> sign(@RequestBody Map<String, Object> payload) {
        String tenantId = TenantContext.getTenantId();

        @SuppressWarnings("unchecked")
        TenantCaseSignValidator<CaseSignRequest> validator =
                (TenantCaseSignValidator<CaseSignRequest>) validators.stream()
                        .filter(v -> v.supports(tenantId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("不支持的租户"));

        // ★ 转成目标子类
        Class<? extends CaseSignRequest> targetType = validator.targetType();
        CaseSignRequest request = objectMapper.convertValue(payload, targetType);

        // 1. 统一的基础校验（JSR-303，可选）
        // validatorFactory.getValidator().validate(request) ...

        // 2. 租户专属校验
        ValidationResult result = validator.validate(request);
        if (!result.isValid()) {
            throw new IllegalArgumentException(String.join(",", result.getErrors()));
        }

        // 3. 业务处理
        return ApiResponse.success(claimSignUseCase.claimSign(request));
    }
}
