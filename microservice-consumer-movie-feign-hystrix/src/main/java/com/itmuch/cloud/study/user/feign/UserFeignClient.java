package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.study.user.entity.User;

//如果classpath下存在Hystrix,那么Feign就会使用断路器包裹Feign客户端的所有方法
@FeignClient(name="microservice-provider-user")//使用该注解会自动创建Ribbon负载均衡器
public interface UserFeignClient {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
}

