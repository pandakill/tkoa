package com.tk.security;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextImpl;

public class SecuritySessionInfo {
	
	private SecurityContextImpl securityContextImpl;
	private String usernameString;
	
	/**
	 * 
	 * @方法说明 获取当前用户的用户名
	 * @创建者 湛耀
	 * @创建日期 2015年7月8日 上午10:54:02
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return String
	 */
	public String getUsername(HttpServletRequest request) {
		//security会把一个SecurityContextImpl对象存储到session中
		securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		try {
			usernameString = securityContextImpl.getAuthentication().getName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usernameString;
	}
	
	public Set<String> getAuthorities(HttpServletRequest request) {
		Set<String> roles = null;
		//security会把一个SecurityContextImpl对象存储到session中
		securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		try {
			roles = AuthorityUtils.authorityListToSet(securityContextImpl.getAuthentication().getAuthorities());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}
}
