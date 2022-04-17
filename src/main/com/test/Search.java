//package main.java.test;
//
//import main.java.entity.User;
//import main.java.mapper.UserMapper;
//import main.java.util.GetSqlSession;
//import org.apache.ibatis.session.SqlSession;
//
//public class Search {
//    public static void main(String[] args) {
//    //获取session对象
//        SqlSession session = GetSqlSession.createsqlsession();
//    //得到对应的mapper
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//    //调用方法，返回用户对象
//        User user = userMapper.queryUserByName("idhar");
//        System.out.println(user);
//    }
//}
