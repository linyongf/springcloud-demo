package com.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

//要扫描所有bean 不然api中*****DeptFeignServiceFallback*******扫描不到
@SpringBootApplication(scanBasePackages = "com.springcloud")
@EnableEurekaClient
//扫描的包要包括公共模块api里面@FeignClient标记接口所在的包，
// 因为pom.xml中引入了api模块，所有要扫描到@FeignClient
@EnableFeignClients(basePackages = {"com.springcloud"})
public class ConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignApplication.class, args);
    }

}
