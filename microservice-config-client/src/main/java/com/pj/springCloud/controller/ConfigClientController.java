package com.pj.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
	@Value("${profile}")//注入git仓库中配置文件的profile属性。
	private String profile;
	
	@GetMapping("/profile")
	public String hello(){
		return profile;
	}
}
