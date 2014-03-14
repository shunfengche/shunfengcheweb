package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class LineDAO extends AbstractDAO implements IGenericDAO{
	

	
	
	/**
	 * ����ִ�ж�������ѯ
	 * 
	 * @param sql
	 *            ���С������Ķ�������ѯ���
	 * @param conditions
	 *            ������ͬ����
	 * @return ��������Ķ��󼯺�
	 */

	public JSONArray getObjectsByConditions(String sql) {
		// ����һ������
		JSONArray array = new JSONArray();
		try {
			// 3)������ݿ�����
			Connection conn = this.getConn();
			// 4)ִ��sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			// 5)��ȡ���
			ResultSet rs = pstmt.executeQuery();
			// 6)������
		
			while (rs.next()) {
			/*	private int lineid;
				private int userid;
				private int seating;
				private int seatleft;
				private int state;
				private String time;
				private String speed;
				private String  origin;
				private String destination;
				private int carlongitude;
				private int carlatitude;
				private String linept;*/
				 JSONObject temp = new JSONObject()  
				
		         .element( "lineid", rs.getInt("lineid"))  
		             .element( "userid", rs.getInt("userid"))  
		                 .element( "seating", rs.getInt("seating"))  
		                     .element( "seatleft", rs.getInt("seatleft"))  
		                        .element( "state", rs.getInt("state"))
		         .element( "time", rs.getString("time"))
		            .element( "speed", rs.getString("speed"))
		                .element( "origin", rs.getString("origin"))
		            .element( "destination", rs.getString("destination"))
		               .element( "carlongitude", rs.getInt("carlongitude"))  
		              .element( "carlatitude", rs.getInt("carlatitude"))
		               ;
				// 
				  array.add(temp);
			}
           
		
			this.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}
    
	

   




}

