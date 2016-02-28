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
	 * 返回图书信息
	 * @return
	 */
	public String bookInfo(){
		System.out.println("图书信息，书名："+bookName+",价格："+price);
		return "图书信息";
	}

}
