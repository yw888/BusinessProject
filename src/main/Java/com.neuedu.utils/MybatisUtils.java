package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private  static  SqlSessionFactory sqlSessionFactory=null;
    static {
        String resource = "mybatis-config.xml";
        SqlSession session;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //ªÒ»°sqlSessionFactory
    public static SqlSessionFactory getSqlSessionFactory(){
        return  sqlSessionFactory;
    }
    //πÿ±’sqlSession
    public static void close(SqlSession sqlSession){
        sqlSession.close();
    }

}
