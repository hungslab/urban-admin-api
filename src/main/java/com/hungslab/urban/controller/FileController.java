package com.hungslab.urban.controller;

import com.hungslab.urban.core.resp.AjaxResult;
import com.hungslab.urban.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author Hungs
 * @date 2024/3/25
 * @Description 文件上传控制器
 */

@RestController
@Tag(name = "文件相关接口")
@RequestMapping("/system/file")
public class FileController extends BaseController {

    @Autowired
    FileService fileService;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @Operation(summary = "文件上传接口")
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) {
        // 检查是否上传了文件
        if (file.isEmpty()) {
            return AjaxResult.error("文件为空");
        }
        try {
            // 保存文件到指定路径，这里为了简单起见直接打印文件名
            String originalFileName = file.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String fileName = uuid + fileExtension;

            file.transferTo(new File("/Users/admin/Desktop/upload" + fileName));

            String url = fileService.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("originalFilename", originalFileName);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @Operation(summary = "oss文件上传接口")
    @PostMapping("/ossupload")
    public AjaxResult ossUpload(MultipartFile file) {
        return null;
    }
}
