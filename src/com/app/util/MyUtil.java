package com.app.util;

import com.app.dao.AbstractDAO;
import com.app.dao.imp.ChatDAO;
import com.app.dao.imp.CommentDAO;
import com.app.dao.imp.DriverDAO;
import com.app.dao.imp.LineDAO;
import com.app.dao.imp.OrderDAO;

import com.app.dao.imp.UserDAO;

import net.sf.json.JSONArray;

public final class MyUtil extends AbstractDAO{
	private static String secret="ffefofeofjaifeofafeofef";
    public JSONArray getjson(String tablename ,String sql){
    	JSONArray array=new JSONArray();
    	if(tablename.equals("chattb")){
    		ChatDAO dao=new ChatDAO();
    		array=dao.getObjectsByConditions(sql);
    	}
    	if(tablename.equals("commenttb")){
    		CommentDAO dao=new CommentDAO();
    		array= dao.getObjectsByConditions(sql);
    	}
    	if(tablename.equals("ordertb")){
    		OrderDAO dao=new OrderDAO();
    		array=dao.getObjectsByConditions(sql);
    	}
    	if(tablename.equals("linetb")){
    		LineDAO dao=new LineDAO();
    		array= dao.getObjectsByConditions(sql);
    	}
    	if(tablename.equals("drivertb")){
    		DriverDAO dao=new DriverDAO();
    		array= dao.getObjectsByConditions(sql);
    	}
    
    	if(tablename.equals("usertb")){
    		UserDAO dao=new UserDAO();
    		array= dao.getObjectsByConditions(sql);
    	}
    	return array;
    }
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public static String getSecret() {
		return secret;
	}
   
}
