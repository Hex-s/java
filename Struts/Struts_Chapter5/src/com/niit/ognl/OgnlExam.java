package com.niit.ognl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niit.bean.Foo;
import com.niit.bean.User;

import ognl.Ognl;
import ognl.OgnlException;

public class OgnlExam {
	public static void main(String[] args) throws OgnlException {
		Foo foo = new Foo();
		foo.setId(1001);
		foo.setStr("niit");
		foo.setArray(new String[]{"A","B","C"});
		foo.setList(Arrays.asList("a","b","c"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "A");
		map.put("b", "B");
		map.put("c", "C");
		foo.setMap(map);
		User user = new User();
		user.setUserName("tom");
		user.setPassword("tom123");
		foo.setUser(user);
		List<User> list = new ArrayList<User>();
		list.add(new User("userA", "pwdA", 20));
		list.add(new User("userB", "pwdB", 30));
		list.add(new User("userC", "pwdC", 25));
		list.add(new User("userD", "pwdD", 35));
		foo.setUserList(list);
		
		//创建Map集合作为Ognl的上下文对象
		HashMap<String, Object> context = new HashMap<String, Object>();
		User user1 = new User("userA", "pwdA", 20);
		User user2 = new User("userB", "pwdB", 30);
		User user3 = new User("userC", "pwdC", 25);
		context.put("user1",user1);
		context.put("user2",user2);
		context.put("user3",user3);
		
		//访问对象中的基本数据类型属性
		Object obj = null;
		//obj = Ognl.getValue("id", foo);
		//obj = Ognl.getValue("str", foo);
		
		//访问数组或List通过[index]
		//obj = Ognl.getValue("list[1]", foo);
		
		//访问map集合通过map.key
		//obj = Ognl.getValue("map.a", foo);
		
		//访问对象类型通过链式访问属性
		//obj = Ognl.getValue("user.userName", foo);
		//obj = Ognl.getValue("userList[1].userName", foo);
		
		//Ognl中可以实现各种运算操作
		//obj = Ognl.getValue("user.userName + str", foo);
		//obj = Ognl.getValue("id + 100", foo);
		//使用单引号表示字符类型的值
		//obj = Ognl.getValue("str = 'str'", foo);
		//System.out.println(foo.getStr());
		//obj = Ognl.getValue("id == 1001 && user.userName == 'tom'", foo);
		
		//方法的调用 直接编写方法名()
		//obj = Ognl.getValue("userInfo()", foo);
		
		//Ognl可以创建ArrayList集合
		//obj = Ognl.getValue("{'a','b','c'}", foo);
		//创建Map集合
		//obj = Ognl.getValue("#{'a':'A','b':'B','c':'C'}", null);
		
		//条件过滤
		//获取foo对象中年龄大于等于25岁的所有用户集合
		//obj = Ognl.getValue("userList.{?#this.age>=25}", foo);
		//System.out.println(obj.getClass().getName());
		//foo.setUserList((ArrayList<User>)obj);
		//System.out.println(Ognl.getValue("userList[2].userName", foo));
		//获取第一个年龄超过25的用户的姓名
		//obj = Ognl.getValue("userList.{^#this.age>25}", foo);
		//获取最后一个年龄小于35的用户
		//obj = Ognl.getValue("userList.{$#this.age<25}.{userName}", foo);
		
		//第一个参数表示OGNL表达式，第二个参数表示OGNL上下文，第三个参数表示上下文对象中的根节点
		//该代码表示从context上下文中查找user1键对应对象的userName属性的值
		//obj = Ognl.getValue("#user1.userName",context,user1);
		//该代码表示直接 从根节点中获取userName属性的值
		obj = Ognl.getValue("userName",context,user1);
		//在struts2中将Ognl重新进行了封装，Struts2中将ActionContext作为Ongl的上下文，将ValueStack作为ActionContext的根节点
		System.out.println(obj);
	}
}
