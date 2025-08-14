package com.axflow.port.external;

/**
 * 影像外部操作端口（OSS/FTP 等多实现）
 *
 * @author wangguangwu
 */
public interface ImagePort {

    /**
     * 是否启用
     *
     * @return true-启用，false-禁用
     */
    boolean isEnabled();

    /**
     * 上传文件到存储系统
     *
     * @param imagePath 本地文件路径（如 /tmp/photo.jpg）
     * @return 存储系统中的唯一标识（如OSS的objectKey）
     */
    String upload(String imagePath);

    /**
     * 下载文件到本地
     *
     * @param imagePath 存储系统中的文件标识（即upload的返回值）
     * @param localPath 本地存储路径（如 /downloads/photo.jpg）
     */
    void download(String imagePath, String localPath);

    /**
     * 删除存储系统中的文件
     *
     * @param imagePath 存储系统中的文件标识
     * @return true-删除成功，false-文件不存在
     */
    boolean delete(String imagePath);

}
