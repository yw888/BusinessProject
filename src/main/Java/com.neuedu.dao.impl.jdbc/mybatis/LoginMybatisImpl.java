package com.neuedu.dao.impl.jdbc.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class LoginMybatisImpl implements ILoginDao{
    @Override
    public Account doLogin(String _username, String _password) {
//        1����ȡ�����ļ�
//        2������SqlSessionFactory
//        ΪSqlSession�Ĺ��������ڽ��������ݿ�ĻỰ��
//        3������SqlSession
//              ����ִ��sql���
//        4������MyBatis�ṩ��api
//        5����ѯMAP����
//        6�����ؽ��
//        7���ر�SqlSession

            String resource = "mybatis-config.xml";
            Reader reader = null;
            SqlSession session;
            try {
                reader = Resources.getResourceAsReader(resource);
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                    .build(reader);
            session = sqlMapper.openSession();
//            ��һ������ΪuserMapper�е������ռ�+select�����id���ڶ�������Ϊid����ָ�����Ĳ���
            Map<String,String> map=new HashMap<String, String>();
            map.put("username",_username);
            map.put("password",_password);
            Account account = session.selectOne("com.neuedu.entity.Account.findByUsernameandPassword", map);
            System.out.println(account);
            session.close();


        return account;
    }

    @Override
    public void addToken(String token, Account acc) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",token);
        map.put("id",acc.getAccountId());
        int result = session.update("com.neuedu.entity.Account.addToken", map);
        System.out.println(result);
        session.close();
    }

    @Override
    public String findTokenByAccountid(int accountid) {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder()
                .build(reader);
        session = sqlMapper.openSession();
//            ��һ������ΪuserMapper�е������ռ�+select�����id���ڶ�������Ϊid����ָ�����Ĳ���

        String token = session.selectOne("com.neuedu.entity.Account.findTokenByAccountid", accountid);
        System.out.println(token);
        session.close();
        return token;
    }
}
