package com.niit.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.form.LoginForm;

/**
 * 框架中的模型 用来处理不同的业务逻辑
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
		//将actionForm强制转换为LoginForm对象
		LoginForm loginForm=(LoginForm)form;
		
		//从表单对象中获取请求的数据
		String userName=loginForm.getUserName();
		String password=loginForm.getPassword();
		
		System.out.println(userName);
		System.out.println(password);
		
		if(userName.equals("admin"))
		{
			if(password.equals("0000"))
			{
				//返回actionForward对象
				return mapping.findForward("success");
			}
		}
		
		return mapping.findForward("failed");
		
		
		
	}
	
}
