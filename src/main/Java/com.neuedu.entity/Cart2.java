package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart2  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  Product  product;
	private  int  productNum;//商品数量
	public Cart2(int id, Product product, int productNum) {
		super();
		this.id = id;
		this.product = product;
		this.productNum = productNum;
	}
	public Cart2() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", productNum=" + productNum + "]";
	}
	
	
	
	
	
	
}
