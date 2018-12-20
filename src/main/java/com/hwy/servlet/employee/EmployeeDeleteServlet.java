/**
 * Copyright (C), 2018
 * FileName: EmployeeDeleteServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 12:35
 * Description:
 */

package com.hwy.servlet.employee;

import com.hwy.service.EmployeeService;
import com.hwy.service.Impl.EmployeeServiceImpl;

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
public class EmployeeDeleteServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = employeeService.deleteEmployeeByIdService(id);

        if (index > 0) {
            //    删除成功
            response.getWriter().print("<script>alert('删除成功!')</script>");
        } else {
            //删除失败
            response.getWriter().print("<script>alert('删除失败!')</script>");
        }
        response.setHeader("refresh", "0;url=/EmployeeList");
    }
}

    