package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itmuch.cloud.study.user.entity.User;

@FeignClient(name="microservice-provider-user")//使用该注解会自动创建Ribbon负载均衡器
public interface UserFeignClient {
	@GetMapping(value="/{id}")
	public User findById(@PathVariable("id") Long id);
}
