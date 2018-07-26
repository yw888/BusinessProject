package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.entity.Cart3;
import com.neuedu.entity.CartItem;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;

public class ProductServiceImpl implements ProductService {

	
	ProductDao productDao=new ProductDaoImpl();
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}
	@Override
	public PageModel<Product> findEmByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return productDao.findEmpByPage(pageNo, pageSize);
	}

	@Override
	public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productDao.findProductByPage(pageNo, pageSize);
	}

	@Override
	public void addProduct2Cart(Cart3 cart, Product product) {
		cart.addProductCart(product);
		
	}

	@Override
	public void changeCartItemNum(String productId, Cart3 cart, int num) {
		CartItem item = cart.getItems().get(productId);
		item.setNum(num);
	}

	
	@Override
	public void delOneItem(Cart3 cart, String productId) {
		cart.getItems().remove(productId);
		
	}
	
}
