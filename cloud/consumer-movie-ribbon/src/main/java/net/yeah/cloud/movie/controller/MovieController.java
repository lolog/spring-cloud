package net.yeah.cloud.movie.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import net.yeah.cloud.movie.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableEurekaClient
public class MovieController {
    public static Logger logger = Logger.getLogger(MovieController.class);
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private EurekaClient eurekaClient;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("consumer/find/{id}")
    public User findby (@PathVariable("id") Integer id) {
        // VIP virtual IP
        // HAProxy Heartbeat
        return restTemplate.getForObject("http://provider-user/provider/find/" + id, User.class);
    }
    
    @GetMapping("choise") 
    public String choise () {
        // 选择
        ServiceInstance serviceInstance1 = loadBalancerClient.choose("provider-user");
        logger.info("1 ==> " + serviceInstance1.getHost() + ":" + serviceInstance1.getPort() + ":" + serviceInstance1.getServiceId());

        ServiceInstance serviceInstance2 = loadBalancerClient.choose("provider-user2");
        logger.info("2 ==> " + serviceInstance2.getHost() + ":" + serviceInstance2.getPort() + ":" + serviceInstance2.getServiceId());
        
        return "successful";
    }

    @GetMapping("/instance/info")
    public String serviceUrl() {
        InstanceInfo instanceUser = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        return instanceUser.getHomePageUrl();
    }

    @GetMapping("get-all")
    public List<?> getAll () {
        // wrong
        // lists的结果为List<LinkedHashMap>, 因此类型不符合要求
        // List<User> lists = restTemplate.getForObject("http://provider-user/get-all", List.class);
        // for (User user: lists) {
        //     System.out.println(user.getId());
        // }

        // right
        User[] users = restTemplate.getForObject("http://provider-user/get-all", User[].class);
        List<User> lists2 = Arrays.asList(users);

        return lists2;
    }
}
