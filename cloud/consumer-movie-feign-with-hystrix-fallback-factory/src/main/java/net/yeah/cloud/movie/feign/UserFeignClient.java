package net.yeah.cloud.movie.feign;

import net.yeah.cloud.movie.factory.UserHystrixFallbackFactory;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// fallback和fallbackFactory冲突，因此配置2个只有一个被调用
// 即，fallbackFactory是fallback的增强版
@FeignClient(name = "provider-user", fallbackFactory = UserHystrixFallbackFactory.class)
public interface UserFeignClient {
    // feign: 1.不支持GetMapping, 2.@PathVariable必须制定value
    @RequestMapping(value = "provider/find/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable("id") Integer id);
}
