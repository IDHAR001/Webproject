package main.java.service;

import com.mysql.cj.Session;

import main.java.entity.MessageModel;
import main.java.entity.User;
import main.java.mapper.UserMapper;
import main.java.util.GetSqlSession;
import main.java.util.StringUtil;
import org.apache.ibatis.session.SqlSession;


/**
 * 业务逻辑
 */
public class UserService {

    /**
     *  用户登录
     *    1.参数非空判断
     *      如果参数为空：将状态码、提示信息、回显数据、设置到消息模型对象中，返回对象
     *    2.调用dao层的查询方法，通过用户名查询对象
     *    3.判断用户对象是否为空
     *      如果为空，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模型对象
     *    4.判断数据库中查询到的用户密码与前台传递过来的密码作比较
     *      如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
     *    5.登录成功
     *      将成功状态码，提示信息，用户对象设置到消息模型对象中，并return
     * @param uname
     * @param upwd
     * @return
     */

    public static MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();


        //回显数据
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        //1.参数的非空判断
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            messageModel.setCode(0);
            messageModel.setMsg("账号密码不能为空");

            return messageModel;
        }

        //2. 调用dao的查询方法，通过用户名查询对象
        SqlSession sqlSession = GetSqlSession.createsqlsession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        //3.判断用户对象是否为空
        if (user == null) {
            //如果为空，将状态码，提示信息，回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在");

            return messageModel;
        }

        //判断数据库中查询到的用户密码与前台传递过来的密码作比较
        //user.getUserPwd()之前已经 user.set过了
        if (!upwd.equals(user.getUserPwd())) {
            //如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("密码错误");
            return  messageModel;
        }

        //登录成功，将用户信息设置到消息模型中
        messageModel.setObject(user);
        messageModel.setCode(1);
        return messageModel;
    }

}
