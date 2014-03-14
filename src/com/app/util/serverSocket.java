package com.app.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

import com.app.dao.imp.ChatDAO;
import com.app.dao.imp.UserDAO;

import net.sf.json.JSONArray;

public class serverSocket {

	/**
	 * @param args
	 */
	public void stratsocket(int port,String username) {
		// TODO Auto-generated method stub
		 
		    serverthread st=new serverthread(port,username);
		    	        	st.start();
		
	}
	  class serverthread extends Thread{
		   int port;
		   String username;
			ServerSocket serversocket;
			  Socket socket = null;
	        public serverthread(int port,String username){
	        	this.port=port;
	        	this.username=username;
	        }
	    	public void run(){
	    	
				try {
					serversocket = new ServerSocket(port);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		while(true) {  
	    		  
					try {
						socket = serversocket.accept();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}//没接到请求就一直堵塞
	    		      if( socket != null){
	    		          
	    	        //	System.out.print("进入serversocket");
	    			
	    				//serversocket.
	    			
	    			  System.out.print("进入serversocket..accept()后");
	    				String sql="select  *  from user_info  where username='"+username+"'";
	    				UserDAO userdao=new UserDAO();
	    				int userid=userdao.getObjectsByConditions(sql).getJSONObject(0).getInt("userid");
	    				 sql="select  *  from chat where isread=0 and  toid="+userid;
	    				ChatDAO cdao=new ChatDAO();
	    				JSONArray array=cdao.getObjectsByConditions(sql);
	    				//如果有聊天
	    				if(array.toString().length()>=3){
	    				sql="update chat set isread=1 where isread=0 and  toid="+userid;
	    				//System.out.println(sql);
	    				cdao.executeDML(sql);
	                
	    			   OutputStream os = null;
					try {
						os = socket.getOutputStream();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			  
	    			 System.out.println(array.toString());
	    				try {
							os.write( array.toString().getBytes("UTF-8"));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    				
	    			   try {
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    				}
	    			   try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    				/*StringBuffer sb=new StringBuffer();
	    			     byte[] buffer = new byte[8192]; // 8k
	    		          int count = 0;
	    		          while ((count = is.read(buffer)) != -1)
	    		          {
	    		            sb.append(new  String(buffer, 0, count));

	    		          }*/
	    		      }    
	    		       
	    		}
	    		        
	    	}
	    	
}
}

