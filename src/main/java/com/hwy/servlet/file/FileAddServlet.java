/**
 * Copyright (C), 2018
 * FileName: FileAddServlet
 * Author:   huangwenyuan
 * Date:     2018/12/17 10:56
 * Description:
 */

package com.hwy.servlet.file;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/17
 * @since 1.0.0
 */
public class FileAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("file/file_add.jsp").forward(request, response);

    }
}

    