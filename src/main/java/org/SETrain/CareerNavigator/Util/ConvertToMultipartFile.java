package org.SETrain.CareerNavigator.Util;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertToMultipartFile {
    public static MultipartFile convertToMultipartFile(String filePath) {

        // 获取路径对象
        Path path = Paths.get(filePath);
        // 获取文件名
        String fileName = path.getFileName().toString();
        String contentType;
        byte[] content;

        try (FileInputStream fis = new FileInputStream(filePath)) {
            // 获取文件的内容类型
            contentType = Files.probeContentType(path);
            // 读取文件内容到字节数组
            content = fis.readAllBytes();
            // 创建并返回一个 CustomMultipartFile 对象
            return new CustomMultipartFile(fileName, fileName, contentType, content);
        } catch (IOException e) {
            // 打印错误信息，便于调试
            e.printStackTrace();
            // 返回 null 表示读取文件失败
            return null;
        }
    }
    }
