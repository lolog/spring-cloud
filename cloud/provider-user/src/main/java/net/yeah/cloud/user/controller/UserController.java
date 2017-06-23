package net.yeah.cloud.user.controller;


import com.google.common.collect.Lists;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import net.yeah.cloud.user.pojo.User;
import net.yeah.cloud.user.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableEurekaClient
public class UserController {
    public static Logger logger = Logger.getLogger(UserController.class);
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/provider/find/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    @PostMapping("provider/find")
    public User postUser (@RequestBody User user) {
        return user;
    }

    @GetMapping("provider/get1")
    public User getUser (@RequestBody User user) {
        return user;
    }

    @GetMapping("provider/get2")
    public User getUser2 (@RequestParam("id") Integer id,
                          @RequestParam("username") String username,
                          @RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("balance") Double balance) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setName(name);
        user.setAge(age);
        user.setBalance(balance);
        return user;
    }
    
    @GetMapping("get-all")
    public List<User> getAll() {
        List<User> lists = Lists.newArrayList();
        User user1 = new User(1, "username1", "name1", 1, 1.1);
        User user2 = new User(2, "username2", "name2", 2, 2.2);
        User user3 = new User(3, "username3", "name3", 3, 3.3);
        User user4 = new User(4, "username4", "name4", 4, 4.4);
        User user5 = new User(5, "username5", "name5", 5, 5.5);
        User user6 = new User(6, "username6", "name6", 6, 6.6);
        
        lists.add(user1);
        lists.add(user2);
        lists.add(user3);
        lists.add(user4);
        lists.add(user5);
        lists.add(user6);
        
        return lists;
    }

    @GetMapping("/instance/info")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("PROVIDER-USER", true);
        
        ServiceInstance serviceInstance = discoveryClient.getInstances("CONSUMER-MOVIE").get(0);
        
        logger.info("PROVIDER-USER="+instance.getHomePageUrl());
        logger.info("CONSUMER-MOVIE="+serviceInstance.getUri().toString());
        
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance/my/info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
        
        return localServiceInstance;
    }
}
