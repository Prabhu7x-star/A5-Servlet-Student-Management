package com.qsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ConnectionPool{
	private static List<Connection> pool=new ArrayList<Connection>();
	private static final String url="jdbc:mysql://localhost:3306/a5servlet";
	private static final String user="root";
	private static final String pass="Prabhu@107329";
	private static final int poolsize=10;
	static {
		for(int i=1;i<=poolsize;i++) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//load driver inside server
				Connection temp=DriverManager.getConnection(url,user,pass);
				pool.add(temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void destroy() throws Exception{
		for(Connection con:pool) {
			con.close();
		}
		pool.clear();
	}
	public static void accept(Connection con) {
		pool.add(con);
	}
	public static Connection supply() {
		// TODO Auto-generated method stub
		return pool.remove(0);
	}
}
