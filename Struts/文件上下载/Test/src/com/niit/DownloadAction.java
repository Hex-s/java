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
		//����������ĸ�ʽ���ַ���
		resp.setContentType("text/html;charset=utf-8"); 
		//���������·��
		String path=req.getParameter("path");
		path = URLDecoder.decode(path,"utf-8");
		//����������·��
		path=getServletContext().getRealPath("/")+path;
		
		System.out.println(path);
		
		//����ļ��Ƿ����
		File file=new File(path);
		
		//����ļ�������
		if(!file.exists())
		{
			String s="�ļ�������";
			resp.getWriter().print(s);
			return;
		}
		
		
		int index=path.lastIndexOf("/");
		
		//��ȡ�����ļ�������
		String fileName=path.substring(index+1);
		
		//��ȡ��Ӧ����������
		ServletOutputStream output=resp.getOutputStream();
		
		//������Ӧ�������Ӧ����
		resp.setHeader("Content-disposition", "attachment;fileName="+fileName);
		
		BufferedInputStream inputStream=null;
		
		BufferedOutputStream outputStream=null;
		
		try
		{
			//������������ȡ�ļ�
			inputStream=new BufferedInputStream(new FileInputStream(path));
			//��װ��Ӧ��������������ļ�
			outputStream=new BufferedOutputStream(output);
			
			//�趨����
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
