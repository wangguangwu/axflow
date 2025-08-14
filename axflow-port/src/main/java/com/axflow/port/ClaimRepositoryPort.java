package com.axflow.port;

import com.axflow.domain.Claim;

import java.util.Optional;

/**
 * 赔案仓储端口（隐藏具体存储实现）
 *
 * @author wangguangwu
 */
public interface ClaimRepositoryPort {

    /**
     * 获取端口名称
     *
     * @return 端口名称
     */
    String name();

    /**
     * 根据赔案号进行查询
     *
     * @param claimCode 赔案号
     * @return 赔案信息
     */
    Optional<Claim> findByClaimCode(String claimCode);

    /**
     * 保存案件数据
     *
     * @param claim 案件数据
     */
    void save(Claim claim);

}
