package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class DriverDAO  extends AbstractDAO implements IGenericDAO{
	

	
	
	

	public JSONArray getObjectsByConditions(String sql) {
	
		JSONArray array = new JSONArray();
		try {
		
			Connection conn = this.getConn();
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			
			ResultSet rs = pstmt.executeQuery();
			
		
			while (rs.next()) {
				/*  private int driverid;
				   private int userid;
				   private String drivinglicenceid;
				   private String carnum;
				   private String drivinglicenceimg;
				   private String carimgi;
				   private String carimgf;
				   private String carimgs;
				   private int zannum;*/
				 JSONObject temp = new JSONObject()  
				
		         .element( "driverid", rs.getInt("driverid"))  
		         .element( "userid", rs.getInt("userid"))  
		         .element( "drivinglicenceid", rs.getString("drivinglicenceid"))
		          .element( "carnum", rs.getString("carnum"))
		            .element( "drivinglicenceimg", rs.getString("drivinglicenceimg"))
		              .element( "carimgi", rs.getString("carimgi"))
		                .element( "carimgf", rs.getString("carimgf"))
		                  .element( "carimgs", rs.getString("carimgs"))
		         .element( "zannum", rs.getInt("zannum"));
		         
			
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


