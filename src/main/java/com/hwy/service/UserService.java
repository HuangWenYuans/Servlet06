/**
 * Copyright (C), 2018
 * FileName: UserService
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:42
 * Description:
 */

package com.hwy.service;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public interface UserService {
    /***
     * 校验用户登录的方法
     * @param username
     * @param password
     * @return
     */
    int checkUserLoginService(String username, String password);
}

    