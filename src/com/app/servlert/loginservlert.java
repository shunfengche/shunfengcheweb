package com.app.servlert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.imp.UserDAO;
import com.app.util.MyUtil;
import com.app.util.portclass;
import com.app.util.serverSocket;

public class loginservlert extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginservlert() {
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

		this.doPost(request, response);
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
      System.out.println("login");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject result=new JSONObject();
	JSONArray array = new JSONArray();
		
		MyUtil util=new MyUtil();
		String secret=MyUtil.getSecret();
		if(request.getParameter("secret")==null){
			result.element("result", "0000");
		}
		else if(request.getParameter("secret").equals(secret)){
		String username=request.getParameter("User[username]").toString();
		String password=request.getParameter("User[password]").toString();
		username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		password=new String(password.getBytes("ISO-8859-1"),"UTF-8");
		UserDAO dao=new UserDAO();
		
		if(dao.isUser(username,password)){
			
		/*	int port=portclass.getPort();
			out.println("1"+port);
			System.out.println("port:"+port);
			serverSocket server=new serverSocket();
			server.stratsocket(port, username);*/
			String sql="select * from usertb where username='"+username+"'";
			System.out.println(sql);
			array=util.getjson("usertb",sql);
			out.print(array.toString());
			   System.out.println(array.toString());
		}
		else{
			 result.element("result", "1001");
		}
		}else  result.element("result", "1000");
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
