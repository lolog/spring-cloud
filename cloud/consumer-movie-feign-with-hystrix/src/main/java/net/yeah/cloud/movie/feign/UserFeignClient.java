package net.yeah.cloud.movie.feign;

import net.yeah.cloud.movie.hystrix.HystrixClientFallback;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {
    // feign: 1.不支持GetMapping, 2.@PathVariable必须制定value
    @RequestMapping(value = "provider/find/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable("id") Integer id);
}
