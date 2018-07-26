package com.neuedu.service;

import java.util.List;


import com.neuedu.entity.Cart3;
import com.neuedu.entity.Product;



public interface CartService3 {

	/**
	 * 添加购物车
	 **/
	boolean  addCart(Cart3 cart);
	/**
	 * 删除
	 * */
	boolean  deleteCart(int id);
	/**
	 * 修改购物车
	 * */
	boolean  updateCart(Cart3 cart);
	/**
	 * 查询购物车
	 * */
	List<Cart3> findAllCart();
	
	/**
	 * 获取购物车中商品数量
	 * */
	int  getCartNum();
	/**修改购物车商品数量
	 * @param  id  要修改的购物车的Id
	 * @param  num 修改后的数量
	 * */
	boolean  updateCart(int id, int num);
	void addProduct2Cart(Cart3 cart, Product product);

	void changeCartItemNum(int productId, Cart3 cart, int num);

	void delOneItem(Cart3 cart, int productId);
	
}
