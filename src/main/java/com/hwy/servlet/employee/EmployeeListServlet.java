/**
 * Copyright (C), 2018
 * FileName: EmployeeListServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:11
 * Description:
 */

package com.hwy.servlet.employee;

import com.hwy.domain.PageInfo;
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
public class EmployeeListServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息
        String city = request.getParameter("city");
        String name = request.getParameter("name");
        //对未输入模糊查询条件的情况进行处理
        if (city == null) {
            city = "";
        }
        if (name == null) {
            name = "";
        }

        //对第一次访问进行验证，如果没有传递参数则设置默认值
        String pageSizeStr = request.getParameter("pageSize");
        String pageNumberStr = request.getParameter("pageNumber");
        //页号默认值
        int pageNumber = 1;
        //每页默认显示的记录条数
        int pageSize = 2;
        if (pageSizeStr != null && !"".equals(pageSizeStr)) {
            pageSize = Integer.parseInt(pageSizeStr);
        }
        if (pageNumberStr != null && !"".equals(pageNumberStr)) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        PageInfo pi = employeeService.showPage(pageSize, pageNumber, city, name);
        request.setAttribute("pageInfo", pi);
        request.setAttribute("city", city);
        request.setAttribute("name", name);
        request.getRequestDispatcher("employee/employee_list.jsp").forward(request, response);

    }
}

    