package net.yeah.cloud.eureka.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

@Component
public class PreZuulFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);
    
    // 类型
    @Override
    public String filterType() {
        return "pre";
    }

    // 执行优先级
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否执行该过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        ServletRequest request = RequestContext.getCurrentContext().getRequest();
        
        String host = request.getRemoteHost();
        
        logger.info("host ===> {}", host);
        
        return null;
    }
}
