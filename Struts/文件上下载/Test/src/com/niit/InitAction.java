package com.niit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitAction extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		
		//获取服务器路径
		String path=getServletContext().getRealPath("/")+"\\data";
		
		File file=new File(path);
		
		File[] files=file.listFiles();
		
		ArrayList<String> fileNameList=new ArrayList<String>();
		
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isFile())
			{
				fileNameList.add(files[i].getName());
			}
		}
		
		req.setAttribute("files", fileNameList);
		
		req.getRequestDispatcher("/WEB-INF/main.jsp").forward(req, resp);
		
	}
	
}
