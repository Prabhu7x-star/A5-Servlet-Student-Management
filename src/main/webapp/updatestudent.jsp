<%@page import="java.sql.ResultSet"%>
<%@page import="com.qsp.repository.StudentRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Student Update  Form</h1>
		<%!
			StudentRepository studentRepo=StudentRepository.getInstance();
		
		%>
		<%
			String email=request.getParameter("email");
			ResultSet rs=studentRepo.getStudentByEmail(email);
			if(rs==null)return;
			rs.next();
			String name=rs.getString(1);
			int age=rs.getInt(2);
			String phone=rs.getString(3);
			
		%>
		<form action="updatestudent">
		<h1>
			<input type="hidden" name="email" value="<%=email %>"><br>
			Name<input type="text" name="name" value="<%=name %>"><br>
			Age<input type="number" name="age" value="<%=age %>"><br>		
			Phone number<input type="text" name="phone" value="<%=phone %>"><br>
			<input type="submit" value="click">
		</h1>
		</form>
		
</body>
</html>