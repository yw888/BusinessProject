package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderItemDaoMybatisImpl implements OrderItemDao{
    @Override
    public boolean addOrderItems(List<UserOrderItem> orederItems) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        OrderItemDao orderItemDao=session.getMapper(OrderItemDao.class);
        orderItemDao.addOrderItems(orederItems);
        session.commit();
        session.close();
        return false;
    }

    @Override
    public int generateOrderItemId() {
        return 0;
    }
}
