package com.axflow.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResult {

    private boolean isValid;
    private List<String> errors;

    public static ValidationResult success() {
        return new ValidationResult(true, Collections.emptyList());
    }

    public static ValidationResult fail(String... errorMessages) {
        return new ValidationResult(false, Arrays.asList(errorMessages));
    }
}
