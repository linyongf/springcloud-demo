package com.springcloud.provider.dao;

import java.util.List;

import com.springcloud.api.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao
{
	 boolean addDept(Dept dept);

	 Dept findById(Long id);

	 List<Dept> findAll();
}
