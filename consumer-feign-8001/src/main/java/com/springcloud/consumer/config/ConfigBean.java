package com.springcloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{ 
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	/**
	 * Feign依赖ribbon，Feign采用的负载均衡策略就是 ribbon的负载均衡策略
	 * 自己手动指定ribbon 负载均衡策略
	 * @return
	 */
	@Bean
	public IRule iRule(){
//		return new RoundRobinRule();//默认 轮询
        return new RandomRule();//随机
//        return new RetryRule();//服务实例状态都好的时候和轮询一样，当有服务实例不可用的时候，访问几次不可用实例就不会再访问了
	}

}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">