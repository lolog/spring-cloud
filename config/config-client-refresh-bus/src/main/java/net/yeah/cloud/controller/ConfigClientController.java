package net.yeah.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
// 注意： RefreshScope和Configuration注解不要一起应用，不然会发生问题
public class ConfigClientController {
    @Value("${profile}")
    private String profile;
    
    @GetMapping("profile")
    public String getProfile () {
        return profile;
    }
}
