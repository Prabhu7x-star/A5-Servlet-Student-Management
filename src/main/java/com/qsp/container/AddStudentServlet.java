package com.qsp.container;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qsp.repository.StudentRepository;

@WebServlet("/addstudent") //DDT (description deployment tool)
public class AddStudentServlet extends HttpServlet{
	private StudentRepository studentrepo=StudentRepository.getInstance();
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.service(req, resp);
		System.out.println("Add student service");
		RequestDispatcher rd=req.getRequestDispatcher("/emptydata");
		
		String name=req.getParameter("sname");
		if(name==null || name.isEmpty()) {
			req.setAttribute("error", "name is empty");
			rd.forward(req, resp);
			return;  // ⬅ Stops execution here
		}
		
		String age=req.getParameter("sage");
		if(age==null || age.isEmpty()) {
			req.setAttribute("error", "age is empty");
			rd.forward(req, resp);
			return;   // ⬅ Stops execution here
		}
		
		String phone=req.getParameter("phone");
		if(phone==null || phone.isEmpty()) {
			req.setAttribute("error", "phone is empty");
			rd.forward(req, resp);
			return;
		}
		
		String email=req.getParameter("email");
		if(email==null || email.isEmpty()) {
			req.setAttribute("error", "email is empty");
			rd.forward(req, resp);
			return;
		}
		System.out.println(name+" "+age+" "+phone+" "+email);
		String response=studentrepo.addStudent(name, age, phone, email);//call repo
		String text="<H1>"+response+"</H1>";
		PrintWriter pw=resp.getWriter();
		pw.println(text);
	}
}
