package com.springcloud.api.service;

import com.springcloud.api.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@FeignClient(value = "microservicecloud-dept")
@FeignClient(value = "microservicecloud-dept", fallbackFactory = DeptFeignServiceFallback.class)
public interface DeptFeignService {
    @GetMapping(value = "/dept/add")
    boolean add(Dept dept) ;

    @GetMapping(value = "/dept/get/{id}")
    Dept get(@PathVariable("id") Long id) ;

    @GetMapping(value = "/dept/list")
    List<Dept> list();
}
