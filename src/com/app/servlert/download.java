package com.app.servlert;

import java.awt.Image;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class download extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public download() {
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
       System.out.println("进入download页面");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		System.out.print("进入download");
		String filename=request.getParameter("filename").toString();
		System.out.print(filename);
		filename=new String(filename.getBytes("ISo-8859-1"),"UTF-8");
		DataOutputStream dos=new DataOutputStream(response.getOutputStream()); 
		// OutputStream out=response.getOutputStream();
		 FileInputStream fis = new FileInputStream(filename);
		 byte[] buffer2 = new byte[8192]; // 每次读8K字节
			int count2 = 0;
			// 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
			while ((count2 = fis.read(buffer2)) > 0)
			{
				dos.write(buffer2, 0, count2); // 向服务端文件写入字节流
				
				//System.out.print(count);
				//out.print(count);
			}
		
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
