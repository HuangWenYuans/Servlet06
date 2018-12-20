/**
 * Copyright (C), 2018
 * FileName: EmployeeAddServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:12
 * Description:
 */

package com.hwy.servlet.employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/19
 * @since 1.0.0
 */
public class EmployeeAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee/employee_add.jsp").forward(request, response);
    }
}

    