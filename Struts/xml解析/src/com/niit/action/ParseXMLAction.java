package com.niit.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM4J解析XML文件
 * @author Administrator
 *
 */
public class ParseXMLAction extends Action
{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		//创建XML文件的读取器
		SAXReader reader=new SAXReader();
		//使用读取器以数据流的方式读取获取document对象
		//Document document=reader.read(new File("src/test.xml"));
		
		String path=request.getRealPath("");
		path+="\\WEB-INF\\test.xml";
		//String path=this.getClass().getResource("/").toString();
		System.out.println(path);
		Document document=reader.read(new File(path));
			
		
		//获取文档的根节点
		Element root=document.getRootElement();
		
//		//打印根节点的名称
//		System.out.println("rootName:"+root.getName());
//		//打印根节点的文本内容
//		System.out.println("rootText:"+root.getText());
//		//获取名称为user的子节点
//		Element el1=root.element("user");
//		//获取子节点中为userName的子节点
//		Element el11=el1.element("userName");
//		System.out.println(el11.getText());
		
		//获取所有所有叫user的子节点集合
//		List<Element> list=root.elements("user");
//		
//		for(Element el : list)
//		{
//			System.out.println(el.getName());
//		}
		
		parseXML(root);
		
		return mapping.findForward("success");
	}
	
	/**
	 * 根据节点解析所有的元素内容
	 * @param el
	 */
	public void parseXML(Element el)
	{
		//获取节点的所有属性
		List<Attribute> attList=el.attributes();
		
		//判断属性是否存在
		if(!attList.isEmpty())
		{
			//遍历所有属性
			for(Attribute att : attList)
			{
				//获取属性的名称 
				String attName=att.getName();
				//获取属性的值
				String attValue=att.getText();
				
				System.out.println(attName+":"+attValue);
			}
		}
		
		//获取节点中的所有子节点
		List<Element> list=el.elements();
		
		//如果包含子节点
		if(!list.isEmpty())
		{
			//遍历节点
			for(Element element : list)
			{
				//获取子节点的名称
				String name=element.getName();
				System.out.println(name);
				//递归 判断是否还包含其余的子节点
				parseXML(element);
			}
		}
		else
		{
			//获取节点中的文本内容
			String text=el.getText();
			System.out.println(text);
		}
	}
}
