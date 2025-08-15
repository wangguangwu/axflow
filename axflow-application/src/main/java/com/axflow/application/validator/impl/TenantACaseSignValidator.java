package com.axflow.application.validator.impl;

import cn.hutool.core.util.StrUtil;
import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.TenantACaseSignRequest;
import com.axflow.application.validator.TenantCaseSignValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
@Component
public class TenantACaseSignValidator implements TenantCaseSignValidator<TenantACaseSignRequest> {

    @Override
    public boolean supports(String tenantId) {
        return "TenantA".equals(tenantId);
    }

    @Override
    public Class<TenantACaseSignRequest> targetType() {
        return TenantACaseSignRequest.class;
    }

    @Override
    public ValidationResult validate(TenantACaseSignRequest req) {
        List<String> errors = new ArrayList<>();
        if (StrUtil.isEmpty(req.getInsuredName())) {
            errors.add("出险人姓名不能为空");
        }
        return errors.isEmpty() ? ValidationResult.success() : ValidationResult.fail(errors.toArray(new String[0]));
    }
}