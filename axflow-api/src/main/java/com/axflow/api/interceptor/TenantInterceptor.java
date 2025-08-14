package com.axflow.api.interceptor;

import com.axflow.application.dto.response.ApiResponse;
import com.axflow.common.enums.ResponseStatusEnum;
import com.axflow.common.tenant.TenantContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author wangguangwu
 */
@Component
public class TenantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String tenantId = request.getHeader("X-Tenant-Id");
        if (tenantId == null || tenantId.isEmpty()) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(
                    new ObjectMapper().writeValueAsString(
                            ApiResponse.fail(ResponseStatusEnum.FAILED.getCode(), "租户ID不能为空")
                    )
            );
            // 终止请求
            return false;
        }
        TenantContext.setTenantId(tenantId);
        return true;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) {
        TenantContext.clear();
    }
}
