package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart3;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	/**添加商品*/
    public  boolean addProduct(Product product);	
    /**查询商品*/
    public  List<Product> findAll();
    /**修改商品*/
    public  boolean  updateProduct(Product product);
    /**删除商品*/
    public  boolean deleteProduct(int id);
    /**根据id查询商品信息*/
    public  Product  findProductById(int id);
    /**分页获取*/
    public PageModel<Product> findEmByPage(Integer pageNo, Integer pageSize);
    public PageMo<Product> findProductByPage(int pageNo, int pageSize);
    void addProduct2Cart(Cart3 cart, Product product);

	void changeCartItemNum(String productId, Cart3 cart, int num);

	void delOneItem(Cart3 cart, String productId);
    
}
