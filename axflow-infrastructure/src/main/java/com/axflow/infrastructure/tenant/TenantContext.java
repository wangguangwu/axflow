package com.axflow.infrastructure.tenant;

/**
 * 线程上下文的租户占位（如需 AbstractRoutingDataSource 可使用）
 *
 * @author wangguangwu
 */
public final class TenantContext {

    private static final ThreadLocal<String> TL = new ThreadLocal<>();

    public static void set(String id) {
        TL.set(id);
    }

    public static String get() {
        return TL.get();
    }

    public static void clear() {
        TL.remove();
    }

    private TenantContext() {
    }
}
