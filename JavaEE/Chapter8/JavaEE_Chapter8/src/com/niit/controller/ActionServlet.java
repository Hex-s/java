package com.niit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.model.AddWareModel;
import com.niit.model.IModel;
import com.niit.model.LoginModel;
import com.niit.model.ShoppingCarModel;
import com.niit.model.ShowAllWareModel;
import com.niit.model.ShowInfoModel;
/**
 * ���Ŀ����������Խ������пͻ������󣬲��ַ�����ͬģ��ʵ��ҵ���߼�����
 * @author Administrator
 *
 */
public class ActionServlet extends HttpServlet {

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
		IModel model = (IModel)getServletContext().getAttribute(value);
		//����ģ�͵Ĵ���ҵ���߼��ķ���
		String url = model.execute(req,resp);
		//����������Ӧ
		req.getRequestDispatcher(url).forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext application = getServletContext();
		//��ģ�Ͷ����ʵ������
		LoginModel loginModel = new LoginModel();
		application.setAttribute("login", loginModel);
		
		//��Ӳ�ѯ������Ʒ��Ϣ��ģ��
		application.setAttribute("init", new ShowAllWareModel());
		//��Ӳ�ѯ��Ʒ��Ϣ��ģ��
		application.setAttribute("showInfo", new ShowInfoModel());
		//��ӹ��ﳵģ��
		application.setAttribute("addWare", new AddWareModel());
		//��Ӳ��Ĺ��ﳵģ��
		application.setAttribute("myCar", new ShoppingCarModel());
	}
	
}
