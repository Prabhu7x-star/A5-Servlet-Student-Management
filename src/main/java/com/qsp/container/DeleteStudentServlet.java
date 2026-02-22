package com.qsp.container;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.repository.StudentRepository;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet{
	private StudentRepository studentrepo=StudentRepository.getInstance();
	@Override
	public void service(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		String email=req.getParameter("email");
		studentrepo.deleteStudentByEmail(email);
		RequestDispatcher rd=req.getRequestDispatcher("allstudent.jsp");
		rd.forward(req, resp);
	}
	
}