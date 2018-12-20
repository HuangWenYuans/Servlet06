/**
 * Copyright (C), 2018
 * FileName: EmployeeEditServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:12
 * Description:
 */

package com.hwy.servlet.employee;

import com.hwy.domain.Employee;
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
public class EmployeeEditServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //    获取请求信息
        //获取文件id
        int id = Integer.parseInt(request.getParameter("id"));
        Employee e = employeeService.loadByEmployeeIdService(id);
        //将employee对象传给employee_edit.jsp
        request.setAttribute("employee", e);
        //请求转发
        request.getRequestDispatcher("employee/employee_edit.jsp").forward(request, response);
    }
}

    