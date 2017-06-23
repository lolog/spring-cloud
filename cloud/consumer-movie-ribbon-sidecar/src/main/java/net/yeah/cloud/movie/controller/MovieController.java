package net.yeah.cloud.movie.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    public static Logger logger = Logger.getLogger(MovieController.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("sidecar")
    public String sidecar () {
        return restTemplate.getForObject("http://gateway-zuul-sidecar/sidecar/", String.class);
    }
}
 