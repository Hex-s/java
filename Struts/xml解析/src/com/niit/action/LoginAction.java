package com.niit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.form.LoginForm;

/**
 * ����е�ģ�� ��������ͬ��ҵ���߼�
 * @author Administrator
 *
 */
public class LoginAction extends Action
{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		//��actionFormǿ��ת��ΪLoginForm����
		LoginForm loginForm=(LoginForm)form;
		
		//�ӱ������л�ȡ���������
		String userName=loginForm.getUserName();
		String password=loginForm.getPassword();
		
		System.out.println(userName);
		System.out.println(password);
		
		if(userName.equals("admin"))
		{
			if(password.equals("0000"))
			{
				//����actionForward����
				return mapping.findForward("success");
			}
		}
		
		return mapping.findForward("failed");
		
		
		
	}
	
}
