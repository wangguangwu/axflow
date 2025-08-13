package com.axflow.api.filter;

import com.axflow.common.tenant.TenantContext;
import jakarta.annotation.Nullable;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    protected void doFilterInternal(HttpServletRequest req, @Nullable HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        String tid = req.getHeader("X-Tenant-Id");
        try {
            TenantContext.setTenantId(tid);
            chain.doFilter(req, res);
        } finally {
            TenantContext.clear();
        }
    }
}
