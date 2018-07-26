package com.neuedu.controller;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

public class CartController {
  CartService cartService=new CartServiceImpl();
	
	/**
	 * ��ӹ��ﳵ
	 **/
	public boolean  addCart(Cart cart) {
		
		return cartService.addCart(cart);
	}
	/**
	 * ɾ��
	 * */
	public boolean  deleteCart(int id) {
		return cartService.deleteCart(id);
	}
	/**
	 * �޸Ĺ��ﳵ
	 * */
	public boolean  updataeCart(Cart cart) {
		return false;
	}
	/**
	 * ��ѯ���ﳵ
	 * */
	public List<Cart> findAllCart(){
		return cartService.findAllCart();
	}
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	public int  getCartNum() {
		return cartService.getCartNum();
	};
	
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	public boolean  updateCart(int id,int num) {
		return  cartService.updateCart(id, num);
	};
}
