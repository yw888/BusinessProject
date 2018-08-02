package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CartDaoMybatisImpl implements CartDao{
    @Override
    public boolean addCart(Cart cart) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.addCart(cart);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteCart(int id) {
        return false;
    }

    @Override
    public boolean updataeCart(Cart cart) {
        return false;
    }

    @Override
    public List<Cart> findAllCart() {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        List<Cart> list=cartDao.findAllCart();
        session.commit();
        session.close();
        return list;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public void clearCart() {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        CartDao cartDao=session.getMapper(CartDao.class);
        cartDao.clearCart();
        session.commit();
        session.close();
    }
}
