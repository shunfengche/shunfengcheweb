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

import net.sf.json.JSONObject;

import com.app.dao.imp.UserDAO;
import com.app.util.MyUtil;

/**
 * Servlet implementation class guestregisterservlert
 */
public class guestregisterservlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public guestregisterservlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hasusernameservlert POST");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject result=new JSONObject();
		String secret=MyUtil.getSecret();
		if(request.getParameter("secret")==null){
			result.element("result", "0000");
		}
		else if(request.getParameter("secret").equals(secret)){
			String username=request.getParameter("User[username]").toString();
			username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
			String password=request.getParameter("User[password]").toString();
			String phnum=request.getParameter("User[phnum]").toString();
			String turename=request.getParameter("User[turename]").toString();
			turename=new String(turename.getBytes("ISO-8859-1"),"UTF-8");
			String cardid=request.getParameter("User[cardid]").toString();
			String sql="insert into usertb values(null,'" +username+
			"','"+password+
			
			"','"+cardid+
	"',null,null,0,1,'"+turename+
	"','男','D://upload/userhead_default.png','什么也没说'"+",'"+phnum+"')";
          System.out.println(sql);
			UserDAO userdao=new UserDAO();
			if(userdao.executeDML(sql))
			
			 result.element("result", "1111");
			else  result.element("result", "1011");
		}
		else result.element("result", "1000");
	    System.out.println(result.toString());
		out.println(result.toString());
	/*	InputStream is=request.getInputStream();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(is));   

	        StringBuilder sb = new StringBuilder();   

	    

	        String line = null;   
  while ((line = reader.readLine()) != null) {   

	                sb.append(line);   

	            }   
		bf.append("User[username]=").append(user)
		.append("&User[password]=").append(password)
		.append("&User[phnum]=").append(phnum)
		.append("&User[turename]=").append(name)
		.append("&User[cardid]=").append(id);*/
	}

}
