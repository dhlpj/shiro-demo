package com.pj.springCloud.zuul.zuulFilter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreRequestLogFilter extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
	
	@Override
	public boolean shouldFilter() {//是否执行filter
		return true;
	}

	@Override
	public Object run() {//过滤器的逻辑
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {//类型：pre、route、post、error
		return "pre";
	}

	@Override
	public int filterOrder() {//执行顺序
		return 1;
	}
}

