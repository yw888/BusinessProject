package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart3;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	/**�����Ʒ*/
    public  boolean addProduct(Product product);	
    /**��ѯ��Ʒ*/
    public  List<Product> findAll();
    /**�޸���Ʒ*/
    public  boolean  updateProduct(Product product);
    /**ɾ����Ʒ*/
    public  boolean deleteProduct(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Product  findProductById(int id);
    /**��ҳ��ȡ*/
    public PageModel<Product> findEmByPage(Integer pageNo, Integer pageSize);
    public PageMo<Product> findProductByPage(int pageNo, int pageSize);
    void addProduct2Cart(Cart3 cart, Product product);

	void changeCartItemNum(String productId, Cart3 cart, int num);

	void delOneItem(Cart3 cart, String productId);
    
}
