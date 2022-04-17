package main.com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GetSqlSession {
    /**
     * 该方法类提供了一个SqlSession
     *
     * @author Administrator
     */
//    public static SqlSession getSqlSession() throws IOException{
//        //1 获取总配置文件
//        Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
//
//        //2 加载总配置文件 获取SqlSessionFactory
//        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
//
//        //3 打开SqlSession
//        SqlSession ss = ssf.openSession();
//
//        return ss;
//    }
//
    public static SqlSession createsqlsession() {
        SqlSessionFactory sqlsessionFactory = null;
        InputStream input = null;
        SqlSession session = null;
        try {
            //获得mybatis的环境配置文件
            String resource = "mybatis-config.xml";
            //以流的方式获取recource(mybatis的环境配置文件)input = Resources.getResourceAsStream(resource);
            input = Resources.getResourceAsStream(resource);
            // 创建会话工厂
            sqlsessionFactory = new SqlSessionFactoryBuilder().build(input);
            //通过工厂得到SqlSession
            session = sqlsessionFactory.openSession();
            return session;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        System.out.println(createsqlsession());
//    }
}
