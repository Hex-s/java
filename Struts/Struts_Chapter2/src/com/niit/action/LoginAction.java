package com.niit.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ʵ��Action�ӿ���Ҫǿ��ʵ��execute����
 * �ýӿ�ͬʱ�ṩ��һЩ�������ڽ���ֵ�ķ���
 * @author Administrator
 *
 */
//public class LoginAction implements Action {
//
//	public String execute() throws Exception {
//		// TODO Auto-generated method stub
//		return SUCCESS;
//	}
//}

/**
 * �̳�ActionSupport��Ҫ��дexecute���������Ҹ����ṩ������У��͹��ʻ���֧��
 */
public class LoginAction extends ActionSupport{
	//��ȡ�����ݣ�������Ӧ�ͱ�Ԫ�ص�nameһ�£����ṩgetter,setter����
	private String userName;
	private String password;
	private int age;
	private String[] hobby;
	
	@Override
	public String execute() throws Exception {
		System.out.println("������loginAction");
		//System.out.println(userName);
		//System.out.println(password);
		
//		//��ȡ��ǰģ�͵������Ķ������ڽ�д�������Ķ��������д��Ҫ��ת��������
//		ActionContext context = ActionContext.getContext();
//		//System.out.println(request.get("userName"));
//		context.put("userName", userName);
//		//��ȡMap ���ڽ�ҳ��ת��ǰ������д��session����
//	    Map<String, Object> session = context.getSession();
//	    session.put("userName", "session");
//	    //���ڽ�ҳ��ת��ǰ������д��servletContext����
//	    Map<String, Object> application = context.getApplication();
//	    application.put("userName", "application");
		
		
		//servletActionContext���Ի�ȡ�������Ӧ�ȶ��������ʵ��
		//��ȡ����
//	    HttpServletRequest request = ServletActionContext.getRequest();
//	    System.out.println(request.getParameter("userName"));
//	    //��ȡ�Ự
//	    HttpSession session = request.getSession();
//	    //��ȡ��Ӧ
//	    HttpServletResponse response = ServletActionContext.getResponse();
//	    //��ȡapplication
//	    ServletContext application = ServletActionContext.getServletContext();
//		
//		//�û��������ж�
//		if(userName.equals("admin")){
//			if(password.equals("0000")){
//				return SUCCESS;
//			}
//			else{
//				return ERROR;
//			}
//		}
//		else{
//			return ERROR;
//		}
		
		System.out.println("age:"+age);
		System.out.print("hobby:");
		if(hobby != null){
			for(String h : hobby){
				System.out.print(h+"\t");
			}
			System.out.println();
		}
		
		return SUCCESS;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
