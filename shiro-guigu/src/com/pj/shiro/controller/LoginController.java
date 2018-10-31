package com.pj.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shiro")
public class LoginController {
	@RequestMapping(value="/login")
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password) {
		System.out.println("login");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            // rememberme
            token.setRememberMe(true);
            try {
                currentUser.login(token);
            } 
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            	System.out.println("µÇÂ½Ê§°Ü"+ae.getMessage());
            }
        }
		return "user";
	}
}
