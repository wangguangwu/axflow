package com.axflow.application.validator.impl;

import cn.hutool.core.util.StrUtil;
import com.axflow.application.dto.ValidationResult;
import com.axflow.application.dto.casesign.TenantACaseSignRequest;
import com.axflow.application.validator.TenantCaseSignValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class TenantACaseSignValidator implements TenantCaseSignValidator<TenantACaseSignRequest> {

    @Override
    public boolean supports(String tenantId) {
        return "TenantA".equals(tenantId);
    }

    @Override
    public ValidationResult validate(TenantACaseSignRequest request) {
        List<String> errors = new ArrayList<>();

        // 租户A专属校验规则
        if (StrUtil.isEmpty(request.getInsuredName())) {
            errors.add("出险人姓名不能为空");
        }

        return errors.isEmpty() ?
                ValidationResult.success() :
                ValidationResult.fail(errors.toArray(new String[0]));
    }
}
