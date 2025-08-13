package com.axflow.port;

import com.axflow.domain.Claim;

import java.util.Map;

/**
 * 案件签收参数校验策略（可按租户多实现）
 *
 * @author wangguangwu
 */
public interface ClaimValidationPort {

    void validateBeforeAccept(Claim claim, Map<String, Object> ctx);

}
