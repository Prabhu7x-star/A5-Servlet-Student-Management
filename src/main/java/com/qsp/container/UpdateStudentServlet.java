package com.qsp.container;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.repository.StudentRepository;

@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet{
	private StudentRepository studentrepo=StudentRepository.getInstance();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String name =req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String phone=req.getParameter("phone");
		studentrepo.updateStudentByEmail(email, name, age, phone);
		RequestDispatcher rd=req.getRequestDispatcher("allstudent.jsp");
		rd.forward(req, resp);
	}
}
