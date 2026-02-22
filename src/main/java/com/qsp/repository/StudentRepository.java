package com.qsp.repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qsp.util.ConnectionPool;

public class StudentRepository {
	private static final StudentRepository obj=new StudentRepository();
	private StudentRepository() {}
	public static final StudentRepository getInstance() {
		return obj;
	}
	public String addStudent(String name,String age,String phone,String email) {
		String sql="insert into student values(?,?,?,?)";
		Connection con=ConnectionPool.supply();
		try {
			PreparedStatement ps=con.prepareStatement(sql); 
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(age));
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionPool.accept(con);
		}
		return "Student added";
	}
	public ResultSet getStudentByEmail(String email) throws SQLException{
		Connection con=ConnectionPool.supply();
		String sql="select * from student where email=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
	    return rs;
		
	}
	public ResultSet getAllStudent() throws SQLException{
		Connection con=ConnectionPool.supply();
		String sql="select * from student";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		ConnectionPool.accept(con);
		return rs;
	}
	public void deleteStudentByEmail(String email) {
		try {
			Connection con=ConnectionPool.supply();
			String sql="delete from student where email=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.executeUpdate();
			ConnectionPool.accept(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateStudentByEmail(String email,String name,int age,String phone) {
		String sql="update student set name=?,age=?,phone=? where email=?";
		try {
			Connection connection=ConnectionPool.supply();
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1,name);
			ps.setInt(2, age);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.executeUpdate();
			ConnectionPool.accept(connection);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
