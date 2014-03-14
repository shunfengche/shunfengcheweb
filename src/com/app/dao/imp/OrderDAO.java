package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class OrderDAO  extends AbstractDAO implements IGenericDAO{
	

	
	
	/**
	 * 用于执行多条件查询
	 * 
	 * @param sql
	 *            带有“？”的多条件查询语句
	 * @param conditions
	 *            各个不同条件
	 * @return 符合条件的对象集合
	 */

	public JSONArray getObjectsByConditions(String sql) {
		// 声明一个集合
		JSONArray array = new JSONArray();
		try {
			// 3)创建数据库连接
			Connection conn = this.getConn();
			// 4)执行sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			// 5)获取结果集
			ResultSet rs = pstmt.executeQuery();
			// 6)处理结果集
		
			while (rs.next()) {
				
			/*	private int orderid;
				private int lineid;
				private int userid;
				private int state;
				private String origin;
				private String destination;
				private int userlongitude;
				private int userlatitude;
				private float money;
				private String time;
				*/
				 JSONObject temp = new JSONObject()   
		         .element( "orderid", rs.getInt("orderid"))  
		           .element( "lineid", rs.getInt("lineid"))  
		             .element( "userid", rs.getInt("userid"))  
		               .element( "state", rs.getInt("state"))  
		         .element( "origin", rs.getString("origin"))
		         .element( "destination", rs.getString("destination"))
		           .element( "userlongitude", rs.getInt("userlongitude"))  
		               .element( "userlatitude", rs.getInt("userlatitude"))  
		         .element( "money", rs.getFloat("money"))
		         .element( "time", rs.getString("ordertime"));
		        
				// 每遍历出一名会员用户，就将其添加到List中
				  array.add(temp);
			}
           
			// 7)释放资源
			this.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}
    
	
   




}

