package net.yeah.cloud.movie.hystrix;

import net.yeah.cloud.movie.feign.UserFeignClient;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements UserFeignClient {
    @Override
    public User findUser(Integer id) {
        User user = new User();
        user.setId(10);
        user.setUsername("username-error");
        user.setName("name-error");
        user.setAge(10);
        user.setBalance(10.0);
        return user;
    }
}
