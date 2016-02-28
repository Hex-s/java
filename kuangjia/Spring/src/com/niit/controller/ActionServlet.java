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
 * 核心控制器，用以接受所有客户端请求，并分发给不同模型实现业务逻辑处理
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
		//获取请求中用来辨识的键所对应的值
		String value = req.getParameter("key");
		//根据请求附带的键值数据分发给不同的业务模型进行处理
		IModel model = (IModel)context.getBean(value);
		//调用模型的处理业务逻辑的方法
		String url = model.execute(req,resp);
		//服务器的响应
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext application = getServletContext();
		//System.out.println("ActionServlet启动");
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
}
