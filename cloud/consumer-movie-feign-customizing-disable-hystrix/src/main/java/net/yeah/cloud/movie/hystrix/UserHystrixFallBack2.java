package net.yeah.cloud.movie.hystrix;

import net.yeah.cloud.movie.feign.UserFeignClient2;
import org.springframework.stereotype.Component;

@Component
public class UserHystrixFallBack2 implements UserFeignClient2{
    @Override
    public String findEurekaByName(String name) {
        return "haha";
    }
}
