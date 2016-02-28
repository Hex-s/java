package com.niit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class UploadAction extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//�Ƿ��ϴ��ɹ��ı�ʶ
		boolean isSuccess=true;
		
		//�����ļ��ϴ�����
		DiskFileUpload disk=new DiskFileUpload();
		
		//�趨�ϴ����ݵ��ַ���
		disk.setHeaderEncoding("utf-8");
		
		//����������ʱ�ļ���
		File tempDirectory=new File("d:/temp");
		
		if(!tempDirectory.exists())
		{
			tempDirectory.mkdir();
		}
	
		//�趨������ʱ�ļ�
		disk.setRepositoryPath("d:/temp");
		
		//�趨�����ļ���С  ��λ�ֽ�
		disk.setSizeThreshold(1024*10);
		
		//�����ϴ��ļ���С
		disk.setSizeMax(1024*1024*100);
		
		try
		{
			//��ȡ��������е���������ȡ�ύ���󼯺�
			List<FileItem> fileList=disk.parseRequest(request);
			
			//�����ύ�Ķ���
			for(FileItem item : fileList)
			{
				//��ȡ�ϴ��ļ���·��(������file)
				//System.out.println(item.getName());
				//��ȡ��Ԫ�ص�name����
				//System.out.println(item.getFieldName());
				//��ȡ�ļ���С
				//System.out.println(item.getSize());
				//��ȡ�ַ�����ʽ���ļ�����
				//System.out.println(item.getString());
				//�ı�������������Ҫ�ع��ַ���
				//System.out.println(new String(item.getString("iso-8859-1").getBytes("iso-8859-1"),"utf-8"));
				
				//�ж��ļ��Ƿ����ϴ�����
				if(!item.isFormField())
				{
					//��ȡ�ϴ��ļ���������
					InputStream input=item.getInputStream();
					
					//��ȡ�ϴ��ļ����ļ���
					String fileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					
					//��ȡ��Ŀ����·��
					String path=getServletContext().getRealPath("/");
					
					//�����ϴ�·��
					path=path+"\\data\\"+fileName;
					
					System.out.println(path);
					
					//��ȡ�����
					FileOutputStream output=new FileOutputStream(new File(path));
					
					int data;
					
					while((data=input.read())!=-1)
					{
						output.write(data);
					}
					
					output.flush();
					output.close();
					input.close();
					
				}
				
			}
			
			
		} catch (FileUploadException e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (Exception e)
		{
			isSuccess=false;
			
			request.setAttribute("error", e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isSuccess)
		{
			request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("/WEB-INF/failed.jsp").forward(request, response);
		}
	}
	
	private void createTempDirectory(int i)
	{
		
	}
	
}
