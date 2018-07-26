package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.entity.Cart3;
import com.neuedu.entity.CartItem;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService3;


public class CartServiceImpl3 implements CartService3 {

	CartDao cartDao=new CartDaoImpl();
	

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean addCart(Cart3 cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCart(Cart3 cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addProduct2Cart(Cart3 cart, Product product) {
		cart.addProductCart(product);	
	}

	@Override
	public void changeCartItemNum(int productId, Cart3 cart, int num) {
		CartItem item = cart.getItems().get(productId);
		item.setNum(num);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void delOneItem(Cart3 cart, int productId) {
		cart.getItems().remove(productId);
		
	}

	@Override
	public List<Cart3> findAllCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return false;
	}

}
