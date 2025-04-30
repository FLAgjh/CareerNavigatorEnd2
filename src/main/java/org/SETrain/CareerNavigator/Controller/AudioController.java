package org.SETrain.CareerNavigator.Controller;

import org.SETrain.CareerNavigator.Entity.Result;
import org.SETrain.CareerNavigator.Util.AliOssUtil;
import org.SETrain.CareerNavigator.Util.ConvertToMultipartFile;
import org.SETrain.CareerNavigator.Util.WebTtsWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/audio")
public class AudioController {


    @GetMapping("/tts")
    public Result tts(@RequestParam String text) throws Exception {
        WebTtsWs webTtsWs=new WebTtsWs();
       String filepath= webTtsWs.TTS(text);
        // 将filepath指向文件上传阿里云，使用fileuploadserviceimpl的方法
        MultipartFile multipartFile= ConvertToMultipartFile.convertToMultipartFile(filepath);
        String originalFilename= multipartFile.getOriginalFilename();
        String fileName= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String url=  AliOssUtil.uploadFile(fileName,multipartFile.getInputStream());

        // 删除本地文件
        if (filepath != null) {
            Files.delete(Paths.get(filepath));
        }
        return Result.success(url);
    }
}
