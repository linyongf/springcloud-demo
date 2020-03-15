package com.springcloud.provider.controller;

import java.util.List;

import com.springcloud.api.entity.Dept;
import com.springcloud.provider.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class ProviderController
{
	@Autowired
	private DeptService service;

	@Autowired
	private DiscoveryClient client;

	@PostMapping(value = "/add")
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@GetMapping("/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@GetMapping("/list")
	public List<Dept> list()
	{
		return service.list();
	}

	@RequestMapping(value = "/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
