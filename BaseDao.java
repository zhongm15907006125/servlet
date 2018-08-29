package cn.java.mydoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	private static String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private static String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=MyDocument";
	private static String user="÷”√˘";
	private static String password="123456";
	
	public static Connection getConnection(){
		
		Connection conn=null;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
    public static void closeAll(Connection cn,Statement st,ResultSet rs){
    	try {
			if(cn!=null) cn.close();
			if(st!=null) cn.close();
			if(rs!=null) cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
