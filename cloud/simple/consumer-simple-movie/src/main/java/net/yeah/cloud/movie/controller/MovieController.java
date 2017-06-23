package net.yeah.cloud.movie.controller;

import net.yeah.cloud.movie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/find/{id}")
    public User findby (@PathVariable("id") Integer id) {
        return restTemplate.getForObject("http://localhost:9090/provider/find/"+id, User.class);
    }
}
