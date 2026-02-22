package com.qsp.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



public class CookieService {
	private static final CookieService object=new CookieService();
	private CookieService() {}
	public static CookieService getInstance() {
		return object;
	}
	public boolean validateCookies(ServletRequest req) {
		HttpServletRequest request=(HttpServletRequest)req;
		Cookie[] cookies=request.getCookies();
		 if (cookies == null || cookies.length==0) {
	            return false;
	        }
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("login") && cookie.getValue().equals(LoginStatus.VALID.getValues())) {
				return true;
			}
		}
		return false;
	}
}
