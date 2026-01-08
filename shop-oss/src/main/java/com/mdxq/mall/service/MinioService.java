package com.mdxq.mall.service;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class MinioService {

    // 注入一个minio客户端实例
    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;// 保存文件的桶名字

    // 对系统日期进行格式化，将不同日期上传的文件存在当天的目录下
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    /**
     * 随机生成一个存储的对象名，由当天的日期 + / + UUID字符串 + 文件后缀
     * @param originalName 原始文件名
     * @return
     */
    private String randomObjectName(String originalName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dateFormat.format(new Date()));// 日期
        stringBuilder.append("/");
        stringBuilder.append(UUID.randomUUID());// 随机的UUID做文件名
        stringBuilder.append(originalName.substring(originalName.lastIndexOf(".")));// 文件后缀名.如.jpj
        return stringBuilder.toString();
    }

    public String uploadFile(MultipartFile file) throws Exception {
        String objectName = randomObjectName(file.getOriginalFilename());// 随机一个文件名
        InputStream in = file.getInputStream();// 获取输入流
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName) // 指定数据桶
                .object(objectName) // 待上传的对象名
                .contentType(file.getContentType()) //指定数据内容格式
                .stream(in, file.getSize(), -1) // 指定数据流传输的部分参数
                .build();
        minioClient.putObject(putObjectArgs);// 完成数据上传
        in.close();
        System.out.println("文件上传成功");
        return objectName;
    }

}
