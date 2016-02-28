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
 * 实现Action接口需要强制实现execute方法
 * 该接口同时提供了一些常量便于进行值的返回
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
 * 继承ActionSupport需要重写execute方法，并且该类提供了数据校验和国际化的支持
 */
public class LoginAction extends ActionSupport{
	//获取表单数据，属性名应和表单元素的name一致，并提供getter,setter方法
	private String userName;
	private String password;
	private int age;
	private String[] hobby;
	
	@Override
	public String execute() throws Exception {
		System.out.println("进入了loginAction");
		//System.out.println(userName);
		//System.out.println(password);
		
//		//获取当前模型的上下文对象，用于将写入上下文对象的数据写入要跳转的请求中
//		ActionContext context = ActionContext.getContext();
//		//System.out.println(request.get("userName"));
//		context.put("userName", userName);
//		//获取Map 用于将页面转发前将数据写入session对象
//	    Map<String, Object> session = context.getSession();
//	    session.put("userName", "session");
//	    //用于将页面转发前将数据写入servletContext对象
//	    Map<String, Object> application = context.getApplication();
//	    application.put("userName", "application");
		
		
		//servletActionContext可以获取请求和相应等对象的真正实例
		//获取请求
//	    HttpServletRequest request = ServletActionContext.getRequest();
//	    System.out.println(request.getParameter("userName"));
//	    //获取会话
//	    HttpSession session = request.getSession();
//	    //获取响应
//	    HttpServletResponse response = ServletActionContext.getResponse();
//	    //获取application
//	    ServletContext application = ServletActionContext.getServletContext();
//		
//		//用户名密码判断
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
