package com.axflow.application.dto.casesign;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class CaseSignRequest {

    /**
     * 案件号
     */
    @NotBlank(message = "案件号不能为空")
    private String caseCode;

    /**
     * 影像件数据
     */
    @NotEmpty(message = "影像件数据不能为空")
    private List<String> imagePathList;

}
