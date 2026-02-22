package com.qsp.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qsp.repository.UserRepository;

public class UserAuthenticationUtil {
	private static UserAuthenticationUtil object=new  UserAuthenticationUtil();
	private  UserAuthenticationUtil() {}
	public static UserAuthenticationUtil getInstance() {
		return object;
	}
	private UserRepository userRepo=UserRepository.getInstance();
	public String userNameAndPasswordAuntheticate(HttpServletRequest req,HttpServletResponse res) throws SQLException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role=null;
		ResultSet rs=userRepo.getUserByUserName(username);
		boolean isUserPresent=false;
		boolean isPasswordValidate=false;
		
		while(rs.next()) {
			isUserPresent=true;
			String dbPassword=rs.getString(2);
			if(password.equals(dbPassword)) {
				isPasswordValidate=true;
				role=rs.getString(3);
				break;
			}
		}
		if(!isUserPresent) return "User not present with name "+username;
		if(!isPasswordValidate) return "invalid password";//isPasswordValidate=false
		Cookie cookie1=new Cookie("login",LoginStatus.VALID.getValues());
		Cookie cookie2=new Cookie("role",role);
		cookie1.setMaxAge(300);
		cookie2.setMaxAge(300);//300sec 5min
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		HttpSession session=req.getSession();
		session.setAttribute("login",LoginStatus.VALID.getValues());
		session.setAttribute("role", role);
		return "login success";
	
		
	}
}
