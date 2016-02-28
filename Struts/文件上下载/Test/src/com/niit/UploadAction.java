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
		//是否上传成功的标识
		boolean isSuccess=true;
		
		//创建文件上传对象
		DiskFileUpload disk=new DiskFileUpload();
		
		//设定上传内容的字符集
		disk.setHeaderEncoding("utf-8");
		
		//创建缓冲临时文件夹
		File tempDirectory=new File("d:/temp");
		
		if(!tempDirectory.exists())
		{
			tempDirectory.mkdir();
		}
	
		//设定缓冲临时文件
		disk.setRepositoryPath("d:/temp");
		
		//设定缓冲文件大小  单位字节
		disk.setSizeThreshold(1024*10);
		
		//设置上传文件大小
		disk.setSizeMax(1024*1024*100);
		
		try
		{
			//读取请求对象中的输入流获取提交对象集合
			List<FileItem> fileList=disk.parseRequest(request);
			
			//遍历提交的对象
			for(FileItem item : fileList)
			{
				//获取上传文件的路径(仅限于file)
				//System.out.println(item.getName());
				//获取表单元素的name属性
				//System.out.println(item.getFieldName());
				//获取文件大小
				//System.out.println(item.getSize());
				//获取字符串形式的文件内容
				//System.out.println(item.getString());
				//文本框中文乱码需要重构字符串
				//System.out.println(new String(item.getString("iso-8859-1").getBytes("iso-8859-1"),"utf-8"));
				
				//判断文件是否是上传对象
				if(!item.isFormField())
				{
					//获取上传文件的输入流
					InputStream input=item.getInputStream();
					
					//获取上传文件的文件名
					String fileName=item.getName().substring(item.getName().lastIndexOf("\\")+1);
					
					//获取项目绝对路径
					String path=getServletContext().getRealPath("/");
					
					//设置上传路径
					path=path+"\\data\\"+fileName;
					
					System.out.println(path);
					
					//获取输出流
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
