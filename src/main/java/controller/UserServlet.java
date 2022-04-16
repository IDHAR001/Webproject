package main.java.controller;

import main.java.entity.MessageModel;
import main.java.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet
 */

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    //实例化UserService对象

    private UserService userService = new UserService();


    /**
     *
     * 用户登录
     *  1.接受客户端请求（账号密码）
     *  2.调用Service层方法，返回消息模型对象
     *  3.判断消息模型的状态码
     *      如果状态码是失败
     *          将消息模型对象设置到request作用域中，请求转发到login.jsp
     *      如果状态码是成功
     *          将消息模型对象中的用户信息存到session作用域中，重定向跳转到user.jsp
     */


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端请求
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        //2.调用service层的方法，返回消息模型
        MessageModel messageModel = UserService.userLogin(uname,upwd);
        //3.判断消息模型的状态码
        if(messageModel.getCode() == 1) { //成功
            //将消息模型对象中的用户信息存到session中，重定向到user.jsp
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("user.jsp");

        } else { //失败
            //将消息模型对象设置到request中，请求转发到login
            request.getSession().setAttribute("messageModel",messageModel);
//            response.sendRedirect("login");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
