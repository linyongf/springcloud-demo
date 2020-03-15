package com.springcloud.consumer.controller;

import com.springcloud.api.entity.Dept;
import com.springcloud.api.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class ConsumerController {
    @Autowired
    private DeptFeignService deptFeignService;

    @GetMapping(value = "/add")
    public boolean add(Dept dept) {
        return deptFeignService.add(dept);
    }

    @GetMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptFeignService.get(id);
    }

    @GetMapping(value = "/list")
    public List<Dept> list() {
        return deptFeignService.list();
    }
}
