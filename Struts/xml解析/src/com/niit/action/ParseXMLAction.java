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
 * ʹ��DOM4J����XML�ļ�
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
		//����XML�ļ��Ķ�ȡ��
		SAXReader reader=new SAXReader();
		//ʹ�ö�ȡ�����������ķ�ʽ��ȡ��ȡdocument����
		//Document document=reader.read(new File("src/test.xml"));
		
		String path=request.getRealPath("");
		path+="\\WEB-INF\\test.xml";
		//String path=this.getClass().getResource("/").toString();
		System.out.println(path);
		Document document=reader.read(new File(path));
			
		
		//��ȡ�ĵ��ĸ��ڵ�
		Element root=document.getRootElement();
		
//		//��ӡ���ڵ������
//		System.out.println("rootName:"+root.getName());
//		//��ӡ���ڵ���ı�����
//		System.out.println("rootText:"+root.getText());
//		//��ȡ����Ϊuser���ӽڵ�
//		Element el1=root.element("user");
//		//��ȡ�ӽڵ���ΪuserName���ӽڵ�
//		Element el11=el1.element("userName");
//		System.out.println(el11.getText());
		
		//��ȡ�������н�user���ӽڵ㼯��
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
	 * ���ݽڵ�������е�Ԫ������
	 * @param el
	 */
	public void parseXML(Element el)
	{
		//��ȡ�ڵ����������
		List<Attribute> attList=el.attributes();
		
		//�ж������Ƿ����
		if(!attList.isEmpty())
		{
			//������������
			for(Attribute att : attList)
			{
				//��ȡ���Ե����� 
				String attName=att.getName();
				//��ȡ���Ե�ֵ
				String attValue=att.getText();
				
				System.out.println(attName+":"+attValue);
			}
		}
		
		//��ȡ�ڵ��е������ӽڵ�
		List<Element> list=el.elements();
		
		//��������ӽڵ�
		if(!list.isEmpty())
		{
			//�����ڵ�
			for(Element element : list)
			{
				//��ȡ�ӽڵ������
				String name=element.getName();
				System.out.println(name);
				//�ݹ� �ж��Ƿ񻹰���������ӽڵ�
				parseXML(element);
			}
		}
		else
		{
			//��ȡ�ڵ��е��ı�����
			String text=el.getText();
			System.out.println(text);
		}
	}
}
