/**
 * Copyright (C), 2018
 * FileName: UserDao
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:43
 * Description:
 */

package com.hwy.dao;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public interface UserDao {
    /***
     *校验用户登录的方法
     * @param username
     * @param password
     * @return
     */
    int check(String username, String password);
}

    