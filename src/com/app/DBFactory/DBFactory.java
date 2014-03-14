package com.app.DBFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBFactory {

	private static String driver;	
	private static String url;	
	private static String username;	
	private static String userpass; 
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	static{
		
		Properties prop = new Properties();
		try {
			prop.load(DBFactory.class.getResourceAsStream("db.properties"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver = prop.getProperty("Driver");
		url = prop.getProperty("url"); 
		username = prop.getProperty("username");
		userpass = prop.getProperty("userpass");
		//ע����
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *
	 * @return  
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, username, userpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public void closeConn(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @param conn ��
	 * @param stmt Statment
	 * @param rs ������
	 */
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		close(rs);
		close(conn,stmt);
	}
	
	public static void close(Connection conn,Statement stmt){
		close(stmt);
		close(conn);
	}
	
	public static void close(Connection conn){
		if(null != conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt){
		if(null != stmt){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs){
		if(null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public  void update(String[] strs){
		String sql="update text set text=?,text2=?,text3=? where id=?";
	    executeDML(sql,strs);
	}
	public boolean executeDML(String sql,Object[] objects){
		boolean target = false;
		System.out.println("executeDML");
		try {
			Connection conn = this.getConn();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int i = 1;
			for(Object obj : objects){
				pstmt.setObject(i++, obj);
			}
			System.out.println(pstmt.toString());
			int j= pstmt.executeUpdate();
			
			if(j > 0)target = true;
			
			this.close(conn, pstmt);
		} catch (SQLException e) {
			return false;
			//e.printStackTrace();
		}
		return target;
	}
	
	}
