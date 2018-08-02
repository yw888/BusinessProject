package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageMo;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductMybatisImpl implements ProductDao {
    @Override
    public boolean addProduct(Product product) {

        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        int result = session.insert("com.neuedu.entity.Product.addProduct", product);
        session.commit();

        return true;
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
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name",product.getName());
        map.put("desc",product.getDesc());
        map.put("price",product.getPrice());
        map.put("rule",product.getRule());
        map.put("image",product.getImage());
        map.put("stock",product.getStock());
        map.put("id",product.getId());
        int result=session.update("com.neuedu.entity.Product.updateProduct",map);
        MybatisUtils.close(session);
        System.out.println("55555555555");
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession(true);
        int result=session.delete("com.neuedu.entity.Product.deleteProduct",id);
        session.close();
        return true;
    }

    @Override
    public Product findById(int id) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        Product product=session.selectOne("com.neuedu.entity.Product.findById",id);
        return product;
    }

    @Override
    public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        int totalCount=(Integer) session.selectOne("com.neuedu.entity.Product.findTotalCount");
        //step2：查询某页的数据
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> products=session.selectList("com.neuedu.entity.Product.findProductbyPage",map);
        PageModel<Product> pageModel=new PageModel<Product>();
        pageModel.setTotalPage(((totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize)+1));
        pageModel.setData(products);

        session.close();
        return pageModel;


    }

    @Override
    public PageMo<Product> findProductByPage(int pageNo, int pageSize) {
        //step1：查询总的记录数----》计算多少页
        SqlSessionFactory factory= MybatisUtils.getSqlSessionFactory();
        SqlSession session=factory.openSession();
        int totalCount=(Integer) session.selectOne("com.neuedu.entity.Product.findTotalCount");
        //step2：查询某页的数据
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("offset",(pageNo-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Product> products=session.selectList("com.neuedu.entity.Product.findProductbyPage",map);
        PageMo<Product> pageMo=new PageMo<Product>();
        pageMo.setTotalPage(((totalCount%pageSize)==0?totalCount/pageSize:(totalCount/pageSize)+1));
        pageMo.setData(products);
        pageMo.setCurrentPage(pageNo);
        session.close();
        return pageMo;
    }
}
