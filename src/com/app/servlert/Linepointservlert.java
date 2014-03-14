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

import com.app.dao.imp.DriverDAO;
import com.app.dao.imp.LineDAO;
import com.app.util.MyUtil;

/**
 * Servlet implementation class Linepointservlert
 */
public class Linepointservlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Linepointservlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LinepointservlertGET");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LinepointservlertPOST");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		JSONObject result=new JSONObject();
		String secret=MyUtil.getSecret();
		if(request.getParameter("secret")==null){
			result.element("result", "0000");
		}
		else if(request.getParameter("secret").equals(secret)){
			/* String str="Line[userid]="
					+userid+"&Line[seating]="
					+seating+"&Line[starttime]="
					
					+starttime+"&Line[speed]="
					+speed+"&Line[starttxt]="
					+starttxt+"&Line[endtxt]="
					+endNode.name+"&Line[carLongitudeE6]="
					+pt.getLongitudeE6()+"&Line[carLatitudeE6]="
					+pt.getLatitudeE6();
				
				
				
				strx.append("/").append(stry);
				str=str+"&Line[linept]="+strx;*/
			
			
			String seating=request.getParameter("Line[seating]").toString();
String starttime=request.getParameter("Line[starttime]").toString();
			
			String speed=request.getParameter("Line[speed]").toString();
String starttxt=request.getParameter("Line[starttxt]").toString();
			
			String endtxt=request.getParameter("Line[endtxt]").toString();
			String carLongitudeE6=request.getParameter("Line[carLongitudeE6]").toString();
			String carLatitudeE6=request.getParameter("Line[carLatitudeE6]").toString();
			String linept=request.getParameter("Line[linept]").toString();
			endtxt=new String(endtxt.getBytes("ISO-8859-1"),"UTF-8");
			starttxt=new String(starttxt.getBytes("ISO-8859-1"),"UTF-8");
			int userid=Integer.parseInt(request.getParameter("Line[userid]").toString());
		int state=0;
			String sql="insert into linetb values(null,"
				+userid+","
				+seating+","
				+seating+","
				+state+",'"
				+starttime+"','"
				+speed+"','"
				+starttxt+"','"
				+endtxt+"',"
				+carLongitudeE6+","
				+carLatitudeE6+",'"
				+linept+"')";
          System.out.println(sql);
			LineDAO dao=new LineDAO();
			if(dao.executeDML(sql))
			
			 result.element("result", "1111");
			else  result.element("result", "1011");
		}
		else result.element("result", "1000");
	    System.out.println(result.toString());
		out.println(result.toString());
		/*InputStream is=request.getInputStream();
		 BufferedReader reader = new BufferedReader(new InputStreamReader(is));   

	        StringBuilder sb = new StringBuilder();   

	    

	        String line = null;   
  while ((line = reader.readLine()) != null) {   

	                sb.append(line );   

	            }   
             String[] strs= sb.toString().split("/");
            String[] Latitudes=strs[0].split(" ");
            String[] Longitudes=strs[0].split(" ");
             
	            System.out.println(sb.toString());*/
	}

}
