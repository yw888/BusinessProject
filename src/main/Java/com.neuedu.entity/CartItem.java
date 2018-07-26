package com.neuedu.entity;


public class CartItem {
	private Product product;
	private int num;
	private double price;//Ð¡¼Æ
	public CartItem(Product product) {
		super();
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return num*product.getPrice();
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
