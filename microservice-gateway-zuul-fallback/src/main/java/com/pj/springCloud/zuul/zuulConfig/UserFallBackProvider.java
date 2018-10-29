package com.pj.springCloud.zuul.zuulConfig;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class UserFallBackProvider implements ZuulFallbackProvider{

	@Override
	public String getRoute() {//表明为哪个为服务提供回退
		return "microservice-provider-user";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			//设置headers
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
				headers.setContentType(mediaType);
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				//响应体
				return new ByteArrayInputStream("用户微服务不可用，请稍后再试".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				//状态文本,这里返回的时OK
				return getStatusCode().getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				//fallback时的状态吗
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				//数字类型的状态码，这里返回200
				return getStatusCode().value();
			}
			
			@Override
			public void close() {
				
			}
		};
	}

}
