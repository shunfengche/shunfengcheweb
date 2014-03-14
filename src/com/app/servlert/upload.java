package com.app.servlert;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;


import org.apache.commons.fileupload.FileItem;

public class upload extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public upload() {
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
			 {

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
			{
		  System.out.println("upload");
	
		try
		{  
			request.setCharacterEncoding("UTF-8"); // 
			response.setContentType("text/html;charset=UTF-8"); 
			FileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory);
		    
			List<FileItem> items = upload.parseRequest(request);
		
			String uploadPath = "d:\\upload\\";
			File file = new File(uploadPath);
			if (!file.exists())
			{
				file.mkdir();
			}
			String filename = ""; 
			InputStream is = null;
		
		
			for (FileItem item : items)
			{
				
				if (item.isFormField())
				{
					if (item.getFieldName().equals("filename"))
					{
						
						if (!item.getString().equals(""))
							filename = item.getString("UTF-8");
					}
				}
				
				else if (item.getName() != null && !item.getName().equals(""))
				{
				
					filename = item.getName().substring(
							item.getName().lastIndexOf("/") + 1);
					is = item.getInputStream(); 
					
				}
			}
		
			filename = uploadPath + filename;
			
			if (new File(filename).exists())
			{
				new File(filename).delete();
			}
			
			if (!filename.equals(""))
			{
				System.out.print(filename);
				
				FileOutputStream fos = new FileOutputStream(filename);
				
				byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�
				int count = 0;
				
				while ((count = is.read(buffer)) > 0)
				{
					fos.write(buffer, 0, count);
				
					//System.out.print(count);
					//out.print(count);
				}
			/*	DataOutputStream dos=new DataOutputStream(response.getOutputStream()); 
				// OutputStream out=response.getOutputStream();
				 FileInputStream fis = new FileInputStream(filename);
				 byte[] buffer2 = new byte[8192]; // ÿ�ζ�8K�ֽ�
					int count2 = 0;
					// ��ʼ��ȡ�ϴ��ļ����ֽڣ����������������˵��ϴ��ļ��������
					while ((count2 = fis.read(buffer2)) > 0)
					{
						dos.write(buffer2, 0, count2); // �������ļ�д���ֽ���
						
						//System.out.print(count);
						//out.print(count);
					}*/
				
				//out.print(is.toString());
				System.out.print(is);
				System.out.print(is.toString());
				fos.close();
				is.close(); 
				//dos.flush();
				System.out.print("上传成功");
				
			}
		}
		catch (Exception e)
		{
           System.out.print("上传失败");
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
