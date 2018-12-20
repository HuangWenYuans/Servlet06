/**
 * Copyright (C), 2018
 * FileName: UserServiceImpl
 * Author:   huangwenyuan
 * Date:     2018/11/29 14:42
 * Description:
 */

package com.hwy.service.Impl;

import com.hwy.dao.Impl.UserDaoImpl;
import com.hwy.dao.UserDao;
import com.hwy.service.UserService;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/11/29
 * @since 1.0.0
 */
public class UserServiceImpl implements UserService {
    //创建UserDao对象
    UserDao ud = new UserDaoImpl();

    /***
     * 校验用户登录的方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public int checkUserLoginService(String username, String password) {

        return ud.check(username, password);
    }
}

    