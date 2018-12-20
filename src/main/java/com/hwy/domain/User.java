/**
 * Copyright (C), 2018
 * FileName: User
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:39
 * Description:
 */

package com.hwy.domain;

/**
 * 功能描述: 用户实体类
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String realname;

    public User() {
    }

    public User(int id, String username, String password, String realname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}

    