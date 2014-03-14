package com.app.servlert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.app.dao.imp.UserDAO;
import com.app.util.MyUtil;

/**
 * Servlet implementation class hasusernameservlert
 */
public class hasusernameservlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hasusernameservlert() {
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
		System.out.println("ﬂM»Îhasusernameservlert POST");
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
			System.out.println(username);
			UserDAO userdao=new UserDAO();
			if(userdao.hasUsername(username))
			
			 result.element("result", "1011");
			else  result.element("result", "1111");
		}
		else result.element("result", "1000");
		 System.out.println(result.toString());
		 out.println(result.toString());
	}

}
