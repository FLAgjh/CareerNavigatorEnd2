package org.SETrain.CareerNavigator.Controller;


import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Util.AliOssUtil;
import org.SETrain.CareerNavigator.Util.CustomMultipartFile;
import org.apache.http.entity.ContentType;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping ("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
      String originalFilename= file.getOriginalFilename();
        String fileName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
       String url=  AliOssUtil.uploadFile(fileName,file.getInputStream());
        return Result.success(url);
    }



}
