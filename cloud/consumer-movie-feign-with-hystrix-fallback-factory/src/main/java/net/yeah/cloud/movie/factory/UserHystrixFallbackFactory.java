package net.yeah.cloud.movie.factory;

import feign.hystrix.FallbackFactory;
import net.yeah.cloud.movie.feign.UserFeignClient;
import net.yeah.cloud.movie.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserHystrixFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static Logger logger = LoggerFactory.getLogger(UserHystrixFallbackFactory.class);
    
    @Override
    public UserFeignClient create(Throwable cause) {
        logger.info("===========================> {}", "UserHystrixFallbackFactory.create()");
        return new UserFeignClient() {
            @Override
            public User findUser(Integer id) {
                User user = new User();
                user.setId(100);
                user.setUsername("username-factory-err");
                user.setName("name-factory-err");
                user.setAge(100);
                user.setBalance(100.0);
                return user;
            }
        };
    }
}
