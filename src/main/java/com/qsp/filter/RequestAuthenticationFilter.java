package com.qsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.qsp.util.CookieService;
import com.qsp.util.SessionService;

@WebFilter(urlPatterns= {"/addstudent","/adduser"})
public class RequestAuthenticationFilter implements Filter {
	private CookieService cookieservice=CookieService.getInstance();
	private SessionService sessionService=SessionService.getInstance();
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Security filter activated");
		if(cookieservice.validateCookies(request) || sessionService.validateSession(request)) {
			chain.doFilter(request, response);
//			return;
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
//			return;
		}
	}
	@Override
	public void destroy() {
		
	}
	
}
