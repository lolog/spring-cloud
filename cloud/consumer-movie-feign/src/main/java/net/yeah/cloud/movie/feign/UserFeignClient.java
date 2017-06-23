package net.yeah.cloud.movie.feign;

import net.yeah.cloud.movie.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("provider-user")
public interface UserFeignClient {
    // feign: 1.不支持GetMapping, 2.@PathVariable必须制定value
    @RequestMapping(value = "provider/find/{id}", method = RequestMethod.GET)
    public User findUser(@PathVariable("id") Integer id);
    
    @RequestMapping(value = "provider/find", method = RequestMethod.POST)
    public User postUser (@RequestBody User user);

    // get 请求方式1
    @RequestMapping(value = "provider/get1", method = RequestMethod.GET)
    public User getUser1 (@RequestBody User user);
    
    // get 请求方式2
    @RequestMapping(value = "provider/get2", method = RequestMethod.GET)
    public User getUser2 (@RequestParam("id") Integer id,
                          @RequestParam("username") String username,
                          @RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("balance") Double balance);
}
