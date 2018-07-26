package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.CartDao2;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.dao.impl.jdbc.CartDaoImpl2;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Cart2;
import com.neuedu.entity.PageMo;
import com.neuedu.service.CartService;
import com.neuedu.service.CartService2;

public class CartServiceImpl2 implements CartService2 {

	CartDao2 cartDao=new CartDaoImpl2();
	
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public PageMo<Cart2> findCartByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cartDao.findCartByPage(pageNo, pageSize);
	}

}
