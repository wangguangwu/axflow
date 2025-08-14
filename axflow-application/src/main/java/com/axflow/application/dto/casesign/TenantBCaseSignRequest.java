package com.axflow.application.dto.casesign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author wangguangwu
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantBCaseSignRequest extends CaseSignRequest {

    private String mainInsuredName;

    private Integer priority;

}
