package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Cart2;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.Product;

/**
 * 
 * 
 * ���ﳵ
 * */
public interface CartDao2 {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��������Ϣ��Id
	 * */
	boolean  deleteCart(int id);
	/**
	 * �޸Ĺ��ﳵ
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * ��ѯ���ﳵ
	 * */
	List<Cart> findAllCart();
	
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	int  getCartNum();
	
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵ���Ʒ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);

	/**
	 * ��չ��ﳵ
	 * */
	void  clearCart() ;
	public PageMo<Cart2> findCartByPage(int pageNo, int pageSize);
	
	
	
}
