package com.axflow.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类（API 模块）
 *
 * @author wangguangwu
 */
@SpringBootApplication(scanBasePackages = "com.axflow")
public class AxFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(AxFlowApplication.class, args);
    }
}
