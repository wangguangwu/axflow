package com.axflow.api.controller;

import com.axflow.application.service.ClaimSignUseCase;
import com.axflow.common.dto.request.ClaimSignReq;
import com.axflow.common.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 签收 Controller（入站）
 *
 * @author wangguangwu
 */
@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
public class ClaimSignController {

    private final ClaimSignUseCase claimSignUseCase;

    @PostMapping("/sign")
    public ApiResponse<String> sign(@RequestBody @Validated ClaimSignReq req) {
        return ApiResponse.success(claimSignUseCase.claimSign(req));
    }
}
