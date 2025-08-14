package com.axflow.adapter.image;

import com.axflow.common.constants.CommonConstant;
import com.axflow.common.constants.ImagePortAdapterConstant;
import com.axflow.port.ImagePort;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 默认影像件端口适配器实现（带日志记录的空操作实现）
 *
 * <p>作为ImagePort接口的默认实现，所有方法均记录日志但不执行实际操作，适用于以下场景：</p>
 * <ul>
 *   <li>测试环境模拟</li>
 *   <li>依赖服务不可用时的降级处理</li>
 *   <li>接口实现的占位模板</li>
 * </ul>
 *
 * @author wangguangwu
 */
@Component
@Slf4j
public class DefaultImagePortAdapter implements ImagePort {

    @Override
    public String name() {
        return CommonConstant.DEFAULT;
    }

    /**
     * 模拟上传文件操作（仅记录日志）
     *
     * @param imagePath 本地文件路径
     * @return 上传地址
     * @throws IllegalArgumentException 如果路径为空
     */
    @Override
    public String upload(String imagePath) {
        log.info("[默认-模拟上传] 文件路径: {}", imagePath);
        return "";
    }

    /**
     * 模拟下载文件操作
     *
     * @param imagePath 远程文件标识
     * @param localPath 本地存储路径
     * @throws IllegalArgumentException 如果参数无效
     */
    @Override
    public void download(String imagePath, String localPath) {
        if (imagePath == null || localPath == null) {
            log.error("下载参数无效: imagePath={}, localPath={}", imagePath, localPath);
            throw new IllegalArgumentException("参数不能为空");
        }

        log.info("[默认-模拟下载] 远程文件: {} -> 本地路径: {}", imagePath, localPath);
    }

    /**
     * 模拟删除文件操作（仅记录日志）
     *
     * @param imagePath 远程文件标识
     * @return 固定返回false并记录警告日志
     */
    @Override
    public boolean delete(String imagePath) {
        log.info("[默认-模拟删除] 文件: {}", imagePath);
        return false;
    }
}
