package com.axflow.api.controller;

import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.common.dto.request.CaseSignRequest;
import com.axflow.common.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 案件处理 controller
 *
 * @author wangguangwu
 */
@RequestMapping("/case")
@RestController
@RequiredArgsConstructor
public class CaseController {

    private final ClaimSignUseCase claimSignUseCase;

    /**
     * 案件签收
     *
     * @param request 签收请求
     * @return 签收号
     */
    @PostMapping("/sign")
    public ApiResponse<String> sign(@RequestBody @Validated CaseSignRequest request) {
        return ApiResponse.success(claimSignUseCase.claimSign(request));
    }
}
