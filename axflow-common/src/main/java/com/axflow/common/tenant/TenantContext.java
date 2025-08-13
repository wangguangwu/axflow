package com.axflow.common.tenant;

/**
 * 线程上下文的租户占位（如需 AbstractRoutingDataSource 可使用）
 *
 * @author wangguangwu
 */
public final class TenantContext {

    private static final ThreadLocal<String> TL = new ThreadLocal<>();

    public static void setTenantId(String tenantId) {
        TL.set(tenantId);
    }

    public static String getTenantId() {
        return TL.get();
    }

    public static void clear() {
        TL.remove();
    }

    private TenantContext() {
    }
}
