package com.pj.springCloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.pj.springCloud.zuul.zuulFilter.PreRequestLogFilter;

@SpringBootApplication
@EnableZuulProxy	//使用Ribbon达到负载均衡,整合了Hystrix
public class ZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
	@Bean
	public PreRequestLogFilter preRequestLogFilter() {
		return new PreRequestLogFilter();
	}
}
