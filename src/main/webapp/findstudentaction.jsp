<%@page import="java.sql.ResultSet"%>
<%@page import="com.qsp.repository.StudentRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        margin-top: 30px;
        color: #333;
    }

    table {
        width: 70%;
        margin: 30px auto;
        border-collapse: collapse;
        background-color: #ffffff;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }

    thead {
        background-color: #2c3e50;
        color: white;
    }

    thead td {
        padding: 12px;
        font-weight: bold;
        text-align: center;
        text-transform: uppercase;
    }

    tbody td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
        color: #333;
    }

    tbody tr:hover {
        background-color: #f1f1f1;
    }
</style>

</head>
<body>

<h1>Student Details</h1>

<%! 
    StudentRepository studentrepo = StudentRepository.getInstance();
%>

<%
    String email = request.getParameter("email");
    ResultSet rs = studentrepo.getStudentByEmail(email);

    String name = "demo";
    int age = -1;
    String phone = "demo";

    if (rs != null && rs.next()) {
        name = rs.getString(1);
        age = rs.getInt(2);
        phone = rs.getString(3);
    }
%>

<table>
    <thead>
        <tr>
            <td>Name</td>
            <td>Age</td>
            <td>Phone</td>
            <td>Email</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><%= name %></td>
            <td><%= age %></td>
            <td><%= phone %></td>
            <td><%= email %></td>
        </tr>
    </tbody>
</table>

</body>
</html>
