package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.DBFactory.DBFactory;;

public abstract class AbstractDAO {
	
		protected Connection getConn(){
			return 	DBFactory.getConn();
		}
		
		/**
		 *
		 * @param 
		 * @param 
		 * @return
		 */
		
		public boolean executeDML(String sql){
			boolean target = false;
			System.out.println("executeDML");
			System.out.println(sql);
			try {
				Connection conn = this.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
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
		public int getcountByConditions(String sql) {
			// TODO Auto-generated method stub
			int num=0;
			Connection conn = this.getConn();
			
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
		
		       System.out.println(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					num++;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return num;
			
		}

		/**
		 * 
		 * @param conn Connection����
		 * @param stmt	Statement����
		 */
		protected void close(Connection conn,Statement stmt){
			DBFactory.close(conn, stmt);
		}
		
		protected void close(Connection conn,Statement stmt,ResultSet rs){
			DBFactory.close(conn, stmt,rs);
		}
		protected void close(ResultSet rs){
			DBFactory.close(rs);
			
		}
		


}
