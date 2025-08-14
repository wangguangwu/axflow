package com.axflow.infrastructure.persistence;

import com.axflow.common.constants.CommonConstant;
import com.axflow.domain.Claim;
import com.axflow.port.ClaimRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author wangguangwu
 */
@Repository
@Slf4j
public class ClaimRepository implements ClaimRepositoryPort {

    @Override
    public String name() {
        return CommonConstant.DEFAULT;
    }

    @Override
    public Optional<Claim> findByClaimCode(String claimCode) {
        log.info("查询案件数据");
        return Optional.empty();
    }

    @Override
    public void save(Claim claim) {
        log.info("保存案件数据");
    }
}
