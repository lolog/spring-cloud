package net.yeah.cloud.movie.feign;

import net.yeah.cloud.config.UserConfiguration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 自定义feign
@FeignClient(name = "name", url = "http://localhost:8092/", configuration = UserConfiguration2.class)
public interface UserFeignClient2 {
    @RequestMapping(value = "eureka/apps/{name}", method = RequestMethod.GET)
    public String findEurekaByName(@PathVariable("name") String name);
}
