package net.yeah.cloud.user.controller;


import net.yeah.cloud.user.pojo.User;
import net.yeah.cloud.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("provider/find/{id}")
    public User findUser (@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }
}
