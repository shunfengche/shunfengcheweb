package com.app.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONArray;

import com.app.dao.AbstractDAO;
import com.app.dao.IGenericDAO;

public class OilinfoDAO extends AbstractDAO {

	public String getMoney(int distant,int seat){
		String sql="select * from oilinfo";
		// 3)创建数据库连接
		Connection conn = this.getConn();
		// 4)执行sql
		PreparedStatement pstmt;
		ResultSet rs;
		float carperoil = 0,oilmoney = 0;
		try {
			pstmt = conn.prepareStatement(sql);
		
	
		// 5)获取结果集
		
	
			rs = pstmt.executeQuery();
	
		// 6)处理结果集
	
			rs.next();
			 carperoil=rs.getFloat(2);
			 oilmoney=rs.getFloat(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println(distant);
		String f=distant*carperoil*oilmoney/1e5/2+1+"";
		f=f.substring(0,f.lastIndexOf(".")+2);
		return  f;

	}
}
