package com.springcloud.consumer.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {
    /**
     * 自己手动指定ribbon 负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        return new MyRule();//服务实例状态都好的时候和轮询一样，当有服务实例不可用的时候，访问几次不可用实例就不会再访问了
    }
}
