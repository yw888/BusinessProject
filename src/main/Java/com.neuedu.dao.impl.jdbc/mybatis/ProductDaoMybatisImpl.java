package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductDaoMybatisImpl  implements ProductDao{
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean updateProduct(Product product) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        //true为自动提交事务
        SqlSession session=factory.openSession(true);
        ProductDao productDao=session.getMapper(ProductDao.class);
        productDao.updateProduct(product);
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
        return null;
    }
}
