package com.mdxq.mall.controller;

import com.mdxq.mall.response.R;
import com.mdxq.mall.service.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/minio")
@CrossOrigin("*")// 允许跨域访问当前文件上传服务
public class MinioController {
    @Autowired
    private MinioService minioService;

    @Value(("${minio.endpoint}"))
    private String endpoint;

    @Value(("${minio.bucket-name}"))
    private String bucketName;

    @PostMapping("upload")
    public R Upload(@RequestParam MultipartFile file) {
        try {
            String filename = minioService.uploadFile(file);
            Map map = new HashMap();
            map.put("url", endpoint + bucketName + "/" + filename);
            return R.ok(map);
        } catch (Exception ex) {
            ex.printStackTrace();
            return R.error();
        }
    }
}
