package com.niit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadAction extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		//设置输出流的格式和字符集
		resp.setContentType("text/html;charset=utf-8"); 
		//服务器相对路径
		String path=req.getParameter("path");
		path = URLDecoder.decode(path,"utf-8");
		//服务器绝对路径
		path=getServletContext().getRealPath("/")+path;
		
		System.out.println(path);
		
		//检查文件是否存在
		File file=new File(path);
		
		//如果文件不存在
		if(!file.exists())
		{
			String s="文件不存在";
			resp.getWriter().print(s);
			return;
		}
		
		
		int index=path.lastIndexOf("/");
		
		//获取下载文件的名称
		String fileName=path.substring(index+1);
		
		//获取响应对象的输出流
		ServletOutputStream output=resp.getOutputStream();
		
		//设置响应对象的响应类型
		resp.setHeader("Content-disposition", "attachment;fileName="+fileName);
		
		BufferedInputStream inputStream=null;
		
		BufferedOutputStream outputStream=null;
		
		try
		{
			//创建输入流读取文件
			inputStream=new BufferedInputStream(new FileInputStream(path));
			//封装响应对象的输出流输出文件
			outputStream=new BufferedOutputStream(output);
			
			//设定缓存
			byte[] buff=new byte[2048];
			
			int data;
			
			while(-1!=(data=inputStream.read(buff, 0, buff.length)))
			{
				outputStream.write(buff, 0, data);
			}
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		finally
		{
			inputStream.close();
			outputStream.close();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
