package com.axflow.port;

import com.axflow.domain.Claim;

import java.util.Optional;

/**
 * 赔案仓储端口（隐藏具体存储实现）
 *
 * @author wangguangwu
 */
public interface ClaimRepositoryPort {

    Optional<Claim> findByCode(String claimCode);

    void save(Claim claim);

}
