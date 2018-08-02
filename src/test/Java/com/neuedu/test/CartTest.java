package com.neuedu.test;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.mybatis.CartDaoMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import org.junit.jupiter.api.Test;

public class CartTest {
    @Test
    public void testAddCart(){
        CartDao cartDao=new CartDaoMybatisImpl();
        Cart cart=new Cart();
        Product product=new Product(3,"华为v10","女性手机",3000,"红色");
        cart.setProduct(product);
        cart.setProductNum(10);
        cartDao.addCart(cart);
    }
}
