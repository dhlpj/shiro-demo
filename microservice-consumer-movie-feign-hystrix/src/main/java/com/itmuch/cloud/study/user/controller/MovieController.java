package com.itmuch.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {
	@Autowired
	private UserFeignClient userFeignClient;

	@HystrixCommand(fallbackMethod = "findByIdFallBack")
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}

	public User findByIdFallBack(Long id) {
		User user = new User();
		user.setId(-1l);
		user.setName("默认用户");
		return user;
	}
}
