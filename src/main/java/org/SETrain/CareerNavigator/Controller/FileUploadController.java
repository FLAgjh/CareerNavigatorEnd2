package org.SETrain.CareerNavigator.Controller;

import org.SETrain.CareerNavigator.Entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping ("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {

        return Result.success("url");

    }


}
