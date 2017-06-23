package net.yeah.cloud.movie.controller;

import net.yeah.cloud.movie.feign.UserFeignClient;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("consumer/find/{id}")
    public User findby(@PathVariable("id") Integer id) {
        return userFeignClient.findUser(id);
    }

    /**
     * Header: Content-Type=application/json
     * {
     *     "id"  : 2,
     *     "username": "kafka",
     *     "name": "kafka",
     *     "age" : 10,
     *     "balance" : 20.1
     * }
     */
    @PostMapping("provider/find/post")
    public User postUser (@RequestBody User user) {
        return userFeignClient.postUser(user);
    }

    /**
     * http://host:port/provider/find/get?id=1&name=kafka&username=kafka&age=10&balance=20.1
     */
    @GetMapping("provider/find/get")
    public User getUser (User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("provider/get1")
    public User getUser1 (User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("provider/get2")
    public User getUser2 (@RequestParam("id") Integer id,
                          @RequestParam("username") String username, 
                          @RequestParam("name") String name, 
                          @RequestParam("age") Integer age, 
                          @RequestParam("balance") Double balance) {
        return userFeignClient.getUser2(id, username, name, age, balance);
    }
}
