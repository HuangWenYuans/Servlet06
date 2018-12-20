/**
 * Copyright (C), 2018
 * FileName: CharacterFilter
 * Author:   huangwenyuan
 * Date:     2018/12/7 13:00
 * Description:
 */

package com.hwy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 功能描述:
 * 设置请求编码格式和响应编码格式
 *
 * @author huangwenyuan
 * @create 2018/12/7
 * @since 1.0.0
 */

@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

    