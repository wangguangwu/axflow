package com.axflow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 赔案聚合根（规则与状态演化；无 IO）
 *
 * @author wangguangwu
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim {

    private String claimCode;

    private List<String> imageRefs;

}
