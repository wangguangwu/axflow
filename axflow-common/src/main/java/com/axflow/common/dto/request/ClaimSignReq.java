package com.axflow.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 案件签收入参
 *
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimSignReq {

    private String claimCode;
    private List<String> imageRefs;
    private String operatorId;

}
