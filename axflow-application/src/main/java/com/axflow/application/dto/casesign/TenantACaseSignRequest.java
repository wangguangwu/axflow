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
public class TenantACaseSignRequest extends CaseSignRequest {

    private String insuredName;

    private String insuredIdNo;

}
