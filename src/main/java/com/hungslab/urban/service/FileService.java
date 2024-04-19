package com.hungslab.urban.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 文件上传
 */
public interface FileService {
    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     *
     * @return 服务地址
     */
    public String getUrl();

    public String getDomain(HttpServletRequest request);


}
