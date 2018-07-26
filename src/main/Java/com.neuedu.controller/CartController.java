package com.neuedu.controller;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

public class CartController {
  CartService cartService=new CartServiceImpl();
	
	/**
	 * 添加购物车
	 **/
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}
	/**
	 * 删除
	 * */
	public boolean  deleteCart(int id) {
		return cartService.deleteCart(id);
	}
	/**
	 * 修改购物车
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * 查询购物车
	 * */
	public List<Cart> findAllCart(){
		return cartService.findAllCart();
	}
	/**
	 * 获取购物车中商品数量
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**修改购物车商品数量
	 * @param  id  要修改的购物车的Id
	 * @param  num 修改后的数量
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
