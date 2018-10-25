package com.itmuch.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现.
 * @author 周立
 */
@SpringBootApplication
@EnableEurekaServer
//@EnableEurekaClient 只适用于服务发现组件Eureka,不能够针对的
public class EurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
  }
}
