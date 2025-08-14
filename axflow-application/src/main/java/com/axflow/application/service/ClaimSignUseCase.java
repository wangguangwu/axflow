package com.axflow.application.service;

import com.axflow.common.dto.request.CaseSignRequest;

/**
 * 签收用例接口（对外能力契约）
 *
 * @author wangguangwu
 */
public interface ClaimSignUseCase {

    /**
     * 案件签收接口
     *
     * @param req 请求
     * @return 签收号
     */
    String claimSign(CaseSignRequest req);

}
