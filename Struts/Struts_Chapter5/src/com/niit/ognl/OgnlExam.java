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
		
		//����Map������ΪOgnl�������Ķ���
		HashMap<String, Object> context = new HashMap<String, Object>();
		User user1 = new User("userA", "pwdA", 20);
		User user2 = new User("userB", "pwdB", 30);
		User user3 = new User("userC", "pwdC", 25);
		context.put("user1",user1);
		context.put("user2",user2);
		context.put("user3",user3);
		
		//���ʶ����еĻ���������������
		Object obj = null;
		//obj = Ognl.getValue("id", foo);
		//obj = Ognl.getValue("str", foo);
		
		//���������Listͨ��[index]
		//obj = Ognl.getValue("list[1]", foo);
		
		//����map����ͨ��map.key
		//obj = Ognl.getValue("map.a", foo);
		
		//���ʶ�������ͨ����ʽ��������
		//obj = Ognl.getValue("user.userName", foo);
		//obj = Ognl.getValue("userList[1].userName", foo);
		
		//Ognl�п���ʵ�ָ����������
		//obj = Ognl.getValue("user.userName + str", foo);
		//obj = Ognl.getValue("id + 100", foo);
		//ʹ�õ����ű�ʾ�ַ����͵�ֵ
		//obj = Ognl.getValue("str = 'str'", foo);
		//System.out.println(foo.getStr());
		//obj = Ognl.getValue("id == 1001 && user.userName == 'tom'", foo);
		
		//�����ĵ��� ֱ�ӱ�д������()
		//obj = Ognl.getValue("userInfo()", foo);
		
		//Ognl���Դ���ArrayList����
		//obj = Ognl.getValue("{'a','b','c'}", foo);
		//����Map����
		//obj = Ognl.getValue("#{'a':'A','b':'B','c':'C'}", null);
		
		//��������
		//��ȡfoo������������ڵ���25��������û�����
		//obj = Ognl.getValue("userList.{?#this.age>=25}", foo);
		//System.out.println(obj.getClass().getName());
		//foo.setUserList((ArrayList<User>)obj);
		//System.out.println(Ognl.getValue("userList[2].userName", foo));
		//��ȡ��һ�����䳬��25���û�������
		//obj = Ognl.getValue("userList.{^#this.age>25}", foo);
		//��ȡ���һ������С��35���û�
		//obj = Ognl.getValue("userList.{$#this.age<25}.{userName}", foo);
		
		//��һ��������ʾOGNL���ʽ���ڶ���������ʾOGNL�����ģ�������������ʾ�����Ķ����еĸ��ڵ�
		//�ô����ʾ��context�������в���user1����Ӧ�����userName���Ե�ֵ
		//obj = Ognl.getValue("#user1.userName",context,user1);
		//�ô����ʾֱ�� �Ӹ��ڵ��л�ȡuserName���Ե�ֵ
		obj = Ognl.getValue("userName",context,user1);
		//��struts2�н�Ognl���½����˷�װ��Struts2�н�ActionContext��ΪOngl�������ģ���ValueStack��ΪActionContext�ĸ��ڵ�
		System.out.println(obj);
	}
}
