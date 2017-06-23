package net.yeah.cloud.movie.feign;

import feign.Param;
import feign.RequestLine;
import net.yeah.cloud.config.UserConfiguration;
import net.yeah.cloud.movie.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;

// 自定义feign
@FeignClient(name = "provider-user", configuration = UserConfiguration.class)
public interface UserFeignClient {
    // feign: 1.不支持GetMapping, 2.@PathVariable必须制定value
    // @RequestMapping(value = "provider/find/{id}", method = RequestMethod.GET)
    @RequestLine(value = "GET provider/find/{id}")
    public User findUser(@Param("id") Integer id);
}
