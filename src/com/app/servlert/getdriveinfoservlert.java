package com.app.servlert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.app.dao.imp.DriverDAO;
import com.app.dao.imp.UserDAO;
import com.app.util.MyUtil;

/**
 * Servlet implementation class getdriveinfoservlert
 */
public class getdriveinfoservlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getdriveinfoservlert() {
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
			int userid=Integer.parseInt(request.getParameter("Driver[userid]").toString());
			
		
			
			DriverDAO dao=new DriverDAO();
			
		
				String sql="select * from drivertb where userid="+userid;
				System.out.println(sql);
				array=util.getjson("drivertb",sql);
				out.print(array.toString());
				   System.out.println(array.toString());
			
			}else  result.element("result", "1000");
	}

}
