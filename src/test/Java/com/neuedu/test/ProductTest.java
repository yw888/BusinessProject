package com.neuedu.test;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.mybatis.ProductMybatisImpl;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.Product;
import org.junit.jupiter.api.Test;

public class ProductTest {
    ProductDao productDao=new ProductMybatisImpl();
    @Test
    public void testfindProductByPage(){

        PageMo<Product> pageMo=productDao.findProductByPage(1,4);
        System.out.println(pageMo);
    }
    @Test
    public void testaddProduct(){
        Product product=new Product();
        product.setName("荣耀10");
        product.setDesc("极光色");
        product.setPrice(3200);
        product.setRule("kkkk");
        product.setImage("sssss");
        product.setStock(20);
        boolean result=productDao.addProduct(product);
        System.out.println(result);
    }
    @Test
    public void testUpdateProduct(){
        Product product=new Product();
        product.setName("iphone");
        product.setDesc("极光色");
        product.setPrice(8000);
        product.setRule("kkkk");
        product.setImage("sssss");
        product.setStock(20);
        product.setId(20);
        productDao.updateProduct(product);
    }
    @Test
    public void testdeleteProduct(){
        productDao.deleteProduct(20);
    }
    @Test
    public void testfindById(){
        Product product=productDao.findById(3);
        System.out.println(product);
    }
}
