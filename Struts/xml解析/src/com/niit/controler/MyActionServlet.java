package com.niit.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

/**
 * struts中的核心处理器
 * @author Administrator
 *
 */
public class MyActionServlet extends ActionServlet
{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionServlet#destroy()
	 */
	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		System.out.println("控制器被销毁");
		super.destroy();
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		System.out.println("接受POST请求的处理");
		super.doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionServlet#init()
	 */
	@Override
	public void init() throws ServletException
	{
		// TODO Auto-generated method stub
		System.out.println("控制被初始化");
		super.init();
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionServlet#process(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		System.out.println("正在执行请求的处理……");
		super.process(request, response);
	}

}
