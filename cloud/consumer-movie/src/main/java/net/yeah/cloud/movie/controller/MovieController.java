package net.yeah.cloud.movie.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("consumer/find/{id}")
    public User findby (@PathVariable("id") Integer id) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("PROVIDER-USER", true);
        
        return restTemplate.getForObject(instanceInfo.getHomePageUrl() + "provider/find/"+id, User.class);
    }

    @GetMapping("/instance/info")
    public String serviceUrl() {
        InstanceInfo instanceUser = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instanceUser.getHomePageUrl();
    }
}
