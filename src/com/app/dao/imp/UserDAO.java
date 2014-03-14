package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.po.User;
import com.mysql.jdbc.Statement;
import com.app.dao.IGenericDAO;


public class UserDAO extends AbstractDAO implements IGenericDAO{
	

	
	
	

	public JSONArray getObjectsByConditions(String sql) {
	
		JSONArray array = new JSONArray();
		try {
			
			Connection conn = this.getConn();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			
			ResultSet rs = pstmt.executeQuery();
		
		
			while (rs.next()) {
			/*	private int userid;
				private String username;
				private String password;
				private String telephone;
				private String identitycard;
				private String identitycardimgf;
				private String identitycardimgb;
				private float money;
				private int state;
				private String truename;
				private String sex;
				private String photo;
				private String qianming;*/
				 JSONObject temp = new JSONObject()   
		         .element( "userid", rs.getInt("userid"))  
		         .element( "username", rs.getString("username"))
		            .element( "password", rs.getString("password"))
		             .element( "telephone", rs.getString("telephone"))
		               .element( "identitycard", rs.getString("identitycard"))
		                  .element( "identitycardimgf", rs.getString("identitycardimgf"))
		                     .element( "identitycardimgb", rs.getString("identitycardimgb"))
		           .element( "money", rs.getFloat("money"))
		            .element("state",rs.getInt("state"))
		             .element( "truename", rs.getString("truename"))
		                    .element("sex",rs.getString("sex"))
		                       .element( "photo", rs.getString("photo"))
		                         .element( "qianming", rs.getString("qianming"));
		      
		    
			
				
				  array.add(temp);
			}
           
			
			this.close(conn, pstmt, rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}
    
	
	public boolean isUser(String username,String password){
		boolean flag=false;
		String sql="select * from usertb where username='"+username+"' and password='"+password+"'";
		int count=this.getcountByConditions(sql);
		if(count>=1){
			flag=true;
		}
		return flag;
	}
  
	public boolean hasUsername(String username){
		boolean flag=false;
		String sql="select * from usertb where username='"+username+"'";
		int count=this.getcountByConditions(sql);
		if(count>=1){
			flag=true;
		}
		return flag;
	}
   




}
