package com.niit.bean;

public class Book implements IBook{
	
	private String bookName;
	private double price;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * ����ͼ����Ϣ
	 * @return
	 */
	public String bookInfo(){
		System.out.println("ͼ����Ϣ��������"+bookName+",�۸�"+price);
		return "ͼ����Ϣ";
	}

}
