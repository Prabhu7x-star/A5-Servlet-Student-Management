<%@page import="java.sql.ResultSet"%>
<%@page import="com.qsp.repository.StudentRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Student Data</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background-color: #f4f6f9;
        padding: 30px;
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    thead {
        background-color: #2c3e50;
        color: white;
    }

    th, td {
        padding: 12px 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        text-transform: uppercase;
        font-size: 14px;
        letter-spacing: 0.5px;
    }

    tbody tr:hover {
        background-color: #f1f1f1;
    }

    td {
        color: #333;
        font-size: 14px;
    }
    td a{
     color: inherit;
        font-size: 14px;
        text-decoration: none;
        
    }
    td a:hover{
    color:red;
    }
</style>

</head>
<body>

<h1>All Student Data</h1>

<%!StudentRepository studentRepo = StudentRepository.getInstance();%>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
    </thead>

    <tbody>
    <%
        ResultSet rs = studentRepo.getAllStudent();
        if (rs == null) return;

        while (rs.next()) {
    %>
        <tr>
            <td><%= rs.getString(1) %></td>
            <td><%= rs.getInt(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><a href="updatestudent.jsp?email=<%= rs.getString(4) %>">update</a></td>
            <td><a href="deletestudent?email=<%= rs.getString(4) %>">delete</a></td>
            
        </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>

