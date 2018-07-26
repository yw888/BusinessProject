package com.neuedu.service;

import java.util.List;


import com.neuedu.entity.Cart3;
import com.neuedu.entity.Product;



public interface CartService3 {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart3 cart);
	/**
	 * ɾ��
	 * */
	boolean  deleteCart(int id);
	/**
	 * �޸Ĺ��ﳵ
	 * */
	boolean  updateCart(Cart3 cart);
	/**
	 * ��ѯ���ﳵ
	 * */
	List<Cart3> findAllCart();
	
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	int  getCartNum();
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);
	void addProduct2Cart(Cart3 cart, Product product);

	void changeCartItemNum(int productId, Cart3 cart, int num);

	void delOneItem(Cart3 cart, int productId);
	
}
