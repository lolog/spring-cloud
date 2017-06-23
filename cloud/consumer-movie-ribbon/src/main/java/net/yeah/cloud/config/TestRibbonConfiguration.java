package net.yeah.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import net.yeah.cloud.annotation.ExcludeFromComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 放在@ComponentScan or @SpringBootApplication中，表示全局设置
 * 2. 添加注解，避免1情况
 */
@Configuration
public class TestRibbonConfiguration {
    @Autowired
    private IClientConfig iClientConfig;

    // 方式1
    @Bean
    public IRule ribbonRule(IClientConfig iClientConfig) {
        return new RandomRule();
    }

    // 方式2
    //    @Bean
    //    public IPing ribbonPing(IClientConfig config) {
    //        return new PingUrl();
    //    }
}
