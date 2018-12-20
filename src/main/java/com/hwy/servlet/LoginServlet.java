/**
 * Copyright (C), 2018
 * FileName: LoginServlet
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:30
 * Description:
 */

package com.hwy.servlet;

import com.hwy.service.Impl.UserServiceImpl;
import com.hwy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public class LoginServlet extends HttpServlet {
    //创建UserService服务对象
    UserService us = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");

        //获取用户账号
        String username = request.getParameter("username");
        // 获取用户密码
        String password = request.getParameter("password");

        //如果用户名为空，直接判定用户名不存在
        if (username == null || "".equals(username)) {
            // 用户不存在
            request.setAttribute("flag", 1);
            //跳转到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else if (password == null || "".equals(password)) {
            //如果密码为空，直接判定密码错误
            //密码错误
            request.setAttribute("flag", 2);
            //跳转到登录页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            //   用户名密码都不为空，则去数据库中校验用户名和密码

            int flag = us.checkUserLoginService(username, password);
            switch (flag) {
                case 0:
                    //用户名密码正确
                    request.setAttribute("flag", 0);
                    //跳转到主页面
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case 1:
                    // 用户不存在
                    request.setAttribute("flag", 1);
                    //跳转到登录页面
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                case 2:
                    //密码错误
                    request.setAttribute("flag", 2);
                    //跳转到登录页面
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    break;
                default:
            }
        }
    }
}

    