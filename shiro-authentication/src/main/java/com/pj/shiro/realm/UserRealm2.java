package com.pj.shiro.realm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthenticatingRealm;

public class UserRealm2 extends AuthenticatingRealm {
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		System.out.println("excute Realm2");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = "";
		// 创建一个用户list存放所有用户信息
		List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
		// 用户1
		Map<String, String> user1 = new HashMap<String, String>();
		user1.put("username", "zhao");
		user1.put("password", "123");
		// 用户2
		Map<String, String> user2 = new HashMap<String, String>();
		user2.put("username", "zhang");
		user2.put("password", "123");
		userList.add(user1);
		userList.add(user2);

		boolean flag = false;
		for (Map<String, String> user : userList) {
			if (username.equals(user.get("username"))) {
				password = user.get("password");
				flag = true;
				break;
			}
		}

		if (!flag) {
			throw new UnknownAccountException("没有找到用户 [" + username + "]");
		}

		return new SimpleAuthenticationInfo(username, password, getName());
	}
}