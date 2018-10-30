package com.pj.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Administrator
 * 修改git仓库中的配置文件的内容，需要先向/refresh端点发送一个post请求，来手动刷新配置
 */
@RestController
@RefreshScope
public class ConfigClientController {
	@Value("${profile}")//注入git仓库中配置文件的profile属性。
	private String profile;
	
	@GetMapping("/profile")
	public String hello(){
		return profile;
	}
}
