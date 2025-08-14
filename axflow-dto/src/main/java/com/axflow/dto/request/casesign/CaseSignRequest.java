package com.axflow.dto.request.casesign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 案件签收入参
 *
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseSignRequest {

    /**
     * 案件号
     */
    private String caseCode;

}
