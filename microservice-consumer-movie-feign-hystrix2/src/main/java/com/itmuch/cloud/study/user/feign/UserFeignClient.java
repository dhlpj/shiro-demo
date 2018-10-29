package com.itmuch.cloud.study.user.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.study.user.entity.User;

@FeignClient(name="microservice-provider-user",fallback=FeignClientFallBack.class)//使用该注解会自动创建Ribbon负载均衡器
public interface UserFeignClient {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}
@Component
class FeignClientFallBack implements UserFeignClient{
	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(-1l);
		user.setUsername("默认用户");
		return user;
	}
	
}