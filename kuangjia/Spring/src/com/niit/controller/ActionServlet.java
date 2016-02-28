package com.niit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.model.IModel;

/**
 * ���Ŀ����������Խ������пͻ������󣬲��ַ�����ͬģ��ʵ��ҵ���߼�����
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet {

	private ApplicationContext context;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��ȡ������������ʶ�ļ�����Ӧ��ֵ
		String value = req.getParameter("key");
		//�������󸽴��ļ�ֵ���ݷַ�����ͬ��ҵ��ģ�ͽ��д���
		IModel model = (IModel)context.getBean(value);
		//����ģ�͵Ĵ���ҵ���߼��ķ���
		String url = model.execute(req,resp);
		//����������Ӧ
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext application = getServletContext();
		//System.out.println("ActionServlet����");
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
}
