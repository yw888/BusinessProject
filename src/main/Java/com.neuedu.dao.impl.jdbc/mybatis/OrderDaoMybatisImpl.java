package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderDaoMybatisImpl implements OrderDao {
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        OrderDao orderDao=session.getMapper(OrderDao.class);
        orderDao.createOrder(userOrder);
        session.commit();
        session.close();
        return true;
    }

    @Override
    public int generateOrderId() {
        return 0;
    }
}
