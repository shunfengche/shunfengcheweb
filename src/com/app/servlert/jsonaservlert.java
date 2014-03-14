package com.app.servlert;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class jsonaservlert extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public jsonaservlert() {
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

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
	
	    
		PrintWriter out = response.getWriter();
		//DataBean db=new DataBean();
		if(request.getParameter("json")==null)
			out.print("fswjfoe");
		else
			{
			//JSONArray array = (JSONArray) request.getAttribute("json");
			String str=request.getParameter("json");
		     str=new String(str.getBytes("ISo-8859-1"),"UTF-8");
			JSONArray array=new JSONArray();
		
			array.add(str.substring(1,str.length()-1));
			int index=0;
		
			for(index=0;index<array.size();index++){
			     array.getJSONObject(index);
			     String[] strs=new String[]{
			    		array.getJSONObject(index).get("text1").toString(),
			    		array.getJSONObject(index).get("text2").toString(),
			    		array.getJSONObject(index).get("text3").toString(),
			    		array.getJSONObject(index).get("id").toString(),
			    		 
			     };
			   //  db.update(strs);
			     
			}
			out.print(array.toString()+"fswjfoe");
			System.out.println(str);
		
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
