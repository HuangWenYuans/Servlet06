/**
 * Copyright (C), 2018
 * FileName: UserDaoImpl
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:43
 * Description:
 */

package com.hwy.dao.Impl;

import com.hwy.dao.UserDao;
import com.hwy.domain.User;

import java.sql.*;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public class UserDaoImpl implements UserDao {
    /***
     *校验用户登录的方法
     * @param username
     * @param password
     * @return 0 密码正确，1用户不存在，2密码不正确
     */
    @Override
    public int check(String username, String password) {
        //声明jdbc对象
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        //声明变量
        User u = null;
        int flag = -1;


        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 获取连接
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=oa", "user", "user");
            //   创建sql命令
            String sql = "select * from TUser where username='" + username + "'";
            //    创建sql命令对象
            stmt = conn.createStatement();
            //    执行sql
            rs = stmt.executeQuery(sql);

            if (!rs.next()) {
                //用户名不存在,标识位为1
                flag = 1;
                return flag;
            } else {
                //用户名存在，对密码进行校验
                sql += " and password='" + password+"'";
                rs = stmt.executeQuery(sql);
                if (!rs.next()) {
                    //密码错误
                    flag = 2;
                } else {
                    //用户名密码正确，给user对象赋值
                    u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setRealname(rs.getString("realname"));

                    //标识用户密码正确
                    flag = 0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}

    