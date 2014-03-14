package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class ChatDAO extends AbstractDAO implements IGenericDAO{
	

	
	
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
				 
				 JSONObject temp = new JSONObject()   
		         .element( " chatid", rs.getInt("chatid"))  
		         .element( "fromid", rs.getInt("fromid"))
		         .element( "toid", rs.getString("toid"))
		         .element( "chatcontent", rs.getString("content"))
		         .element( "time", rs.getString("time"))
		         .element( "flag", rs.getInt("flag"))
				 .element( "freeze", rs.getInt("freeze"))
				 .element( "isread", rs.getInt("isread"));
			
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
