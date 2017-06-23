package net.yeah.cloud.movie.controller;

import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import net.yeah.cloud.movie.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    public static Logger logger = Logger.getLogger(MovieController.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private EurekaClient eurekaClient;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("consumer/find/{id}")
    @HystrixCommand(fallbackMethod = "findByFallBack", 
                        // 平时不用配置，抛异常再配置
                        commandProperties = {
                            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
                        }
                    )
    public User findby (@PathVariable("id") Integer id) {
        // VIP virtual IP
        // HAProxy Heartbeat
        return restTemplate.getForObject("http://provider-user/provider/find/" + id, User.class);
    }
    
    // 回调方法
    // 参数和返回值与原方法相同
    public User findByFallBack (Integer id) {
        User user = new User();
        user.setId(10);
        user.setUsername("username10");
        user.setName("name10");
        user.setAge(10);
        user.setBalance(10.0);
        return user;
    }
}
