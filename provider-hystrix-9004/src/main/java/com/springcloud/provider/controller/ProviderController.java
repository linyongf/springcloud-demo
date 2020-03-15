package com.springcloud.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.api.entity.Dept;
import com.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class ProviderController
{
	@Autowired
	private DeptService service;

	@PostMapping(value = "/add")
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@GetMapping("/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrixGet")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept = this.service.get(id);

		if (null == dept) {
			throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
		}

		return dept;
	}

	public Dept processHystrixGet(@PathVariable("id") Long id)
	{
		return new Dept().setId(id).setName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setSource("no this database in MySQL");
	}

	@GetMapping("/list")
	public List<Dept> list()
	{
		return service.list();
	}
}
