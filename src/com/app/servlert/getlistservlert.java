package com.app.servlert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.app.util.MyUtil;



public class getlistservlert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public getlistservlert() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      System.out.print("getlistservlert");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//DataBean db=new DataBean();
		JSONArray array = new JSONArray();
		
		MyUtil util=new MyUtil();
	/*	String str=request.getParameter("json");
	     str=new String(str.getBytes("ISo-8859-1"),"UTF-8");
	     System.out.println(str);	*/
	     InputStream is=request.getInputStream();
	     BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);  
	    StringBuilder sb = new StringBuilder();  
	        String line = null;  
	        while ((line = reader.readLine()) != null) {  
	                sb.append(line + "\n");  
	        }
	        String str=sb.toString();
	      //  str=str.substring(1,str.length()-1);
	     System.out.println(str);	   
	 	    JSONObject json=JSONObject.fromObject(str);
		    	String	sql=json.getString("sql").toString().trim();
		    	String tablename=json.getString("tablename").toString();
		    	String type=json.getString("type").toString();
		    System.out.println(sql);	
		    System.out.println(tablename);	
		    System.out.println(type);	
		//
		if(type.equals("1")){
			if(util.executeDML(sql)){
				out.print("1");
			}
			else out.print("0");
		}
		//
		if(type.equals("0")){
		array=util.getjson(tablename,sql);
		out.print(array.toString());
		   System.out.println(array.toString());	
		}
	
	}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
