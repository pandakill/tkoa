package com.tk.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class TkoaLoginSuccessHandler implements
	AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String path = request.getContextPath() ;
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";         
        //匹配用户权限，重定向页面到相应的 action 
        if (roles.contains("ROLE_SUPER") || roles.contains("ROLE_ADMIN") || roles.contains("ROLE_EMPLOYEE")){
            response.sendRedirect(basePath+"adminIndex.do");   
        } else {
        	//如果和所有权限都不匹配，则重定向至登录页面
        	response.sendRedirect(basePath+"login.jsp");    
        }
	}

}
