package com.niit;

public class Test
{
	public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.126.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);
     //设置邮箱用户名和密码
     mailInfo.setUserName("xxxx@126.com");    
     mailInfo.setPassword("pwdxxxx");   
     //设置发送邮件的邮箱和
     mailInfo.setFromAddress("xxx@126.com");  
     //接受邮件的邮箱
     mailInfo.setToAddress("xxx@qq.com");    
     mailInfo.setSubject("测试邮件");    
     //设置邮件内容
     mailInfo.setContent("<a href='#'>test Content</a>");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         //sms.sendTextMail(mailInfo);//发送文体格式    
         sms.sendHtmlMail(mailInfo);//发送html格式   
   }  

}
