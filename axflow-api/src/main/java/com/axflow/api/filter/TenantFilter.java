package com.axflow.api.filter;

import com.axflow.common.dto.response.ApiResponse;
import com.axflow.common.enums.ApiResponseStatusEnum;
import com.axflow.common.tenant.TenantContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 租户 id 处理
 *
 * @author wangguangwu
 */
@Component
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String tenantId = req.getHeader("X-Tenant-Id");
        if (tenantId == null || tenantId.isEmpty()) {
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            res.setContentType(MediaType.APPLICATION_JSON_VALUE);
            res.getWriter().write(
                    new ObjectMapper().writeValueAsString(
                            ApiResponse.fail(ApiResponseStatusEnum.FAILED.getCode(), "租户ID不能为空")
                    )
            );
            // 关键：终止过滤器链
            return;
        }

        try {
            TenantContext.setTenantId(tenantId);
            chain.doFilter(req, res);
        } finally {
            TenantContext.clear();
        }
    }
}
