package com.axflow.application.validator.impl;

import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.TenantBCaseSignRequest;
import com.axflow.application.validator.TenantCaseSignValidator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
@Component
public class TenantBCaseSignValidator implements TenantCaseSignValidator<TenantBCaseSignRequest> {

    @Override
    public boolean supports(String tenantId) {
        return "TenantB".equals(tenantId);
    }

    @Override
    public Class<TenantBCaseSignRequest> targetType() {
        return TenantBCaseSignRequest.class;
    }

    @Override
    public ValidationResult validate(TenantBCaseSignRequest req) {
        List<String> errors = new ArrayList<>();
        if (req.getMainInsuredName() != null && req.getMainInsuredName().length() > 20) {
            errors.add("主被保险人姓名不能超过20字");
        }
        if (req.getPriority() == null) {
            errors.add("必须指定优先级");
        }
        return errors.isEmpty() ? ValidationResult.success() : ValidationResult.fail(errors.toArray(new String[0]));
    }
}
