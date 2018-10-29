package com.itmuch.cloud.study.user.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.study.user.entity.User;

import feign.hystrix.FallbackFactory;

@FeignClient(name="microservice-provider-user",fallbackFactory=FeignClientFallBackFactory.class)//使用该注解会自动创建Ribbon负载均衡器
public interface UserFeignClient {
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
}
@Component
class FeignClientFallBackFactory implements FallbackFactory<UserFeignClient>{
	private static final Logger LOGGER = LoggerFactory.
			getLogger(FeignClientFallBackFactory.class);
	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {
			@Override
			public User findById(Long id) {
				FeignClientFallBackFactory.LOGGER.info("fallback;reason was:",cause);
				User user = new User();
				if(cause instanceof IllegalArgumentException) {
					user.setId(-2l);
				}else {
					user.setId(-1l);
				}
				user.setUsername("默认用户");
				return user;
			}
		};
	}
	
}
