package com.niit.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionServlet;

/**
 * struts�еĺ��Ĵ�����
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
		System.out.println("������������");
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
		System.out.println("����POST����Ĵ���");
		super.doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionServlet#init()
	 */
	@Override
	public void init() throws ServletException
	{
		// TODO Auto-generated method stub
		System.out.println("���Ʊ���ʼ��");
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
		System.out.println("����ִ������Ĵ�����");
		super.process(request, response);
	}

}
