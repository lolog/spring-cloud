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
}
