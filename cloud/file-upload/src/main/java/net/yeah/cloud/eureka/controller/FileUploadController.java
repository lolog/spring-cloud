package net.yeah.cloud.eureka.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class FileUploadController {
    // 命令行
    // curl -F "file=@文件名" localhost:8125/upload
    @PostMapping(value = "upload")
    public String handleFileUpload (@RequestParam(value = "file", required = true) MultipartFile file) throws Exception{
        byte[] bytes = file.getBytes();
        File filetoSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, filetoSave);
        
        return filetoSave.getAbsolutePath();
    }
    
    @GetMapping("test")
    public String test () {
        return "test";
    }
}
