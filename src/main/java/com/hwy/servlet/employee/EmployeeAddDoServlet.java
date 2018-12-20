/**
 * Copyright (C), 2018
 * FileName: EmployeeAddDoServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:12
 * Description:
 */

package com.hwy.servlet.employee;

import com.hwy.service.EmployeeService;
import com.hwy.service.Impl.EmployeeServiceImpl;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/19
 * @since 1.0.0
 */
public class EmployeeAddDoServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置文件上传保存路径
        String filePath = getServletContext().getRealPath("/") + "/employeeIcon";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //    实例化上传组件
        SmartUpload su = new SmartUpload();
        //    初始化SmartUpload
        su.initialize(getServletConfig(), request, response);
        //    设置上传文件的大小上限
        su.setMaxFileSize(1024 * 1024 * 2);
        //    设置所有文件大小上限
        su.setTotalMaxFileSize(1024 * 1024 * 50);
        //    设置允许上传文件的类型
        su.setAllowedFilesList("txt,jpg,gif,png");
        su.setCharset("utf-8");
        try {
            //    上传文件
            su.upload();
            //   将文件保存到设置的路径下
            su.save(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        com.jspsmart.upload.File smartFile = su.getFiles().getFile(0);
        String iconName = null;
        try {
            //如果上传了文件的话，则设置文件的文件名
            if (smartFile.getFileName() != null && !"".equals(smartFile.getFileName())) {
                //生成唯一的uuid
                String uuid = UUID.randomUUID().toString();
                //截取文件的后缀名
                String suffix = smartFile.getFileName().substring(smartFile.getFileName().lastIndexOf("."));
                //文件名
                iconName = uuid + suffix;
                smartFile.saveAs("/employeeIcon/" + iconName);
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        //获取文件信息
        String name = su.getRequest().getParameter("name");
        String work_date = su.getRequest().getParameter("work_date");
        String address = su.getRequest().getParameter("address");
        String city = su.getRequest().getParameter("city");
        //将文件添加到数据库
        int index = employeeService.addEmployeeService(name, work_date, address, city, iconName);
        if (index > 0) {
            //添加成功
            response.getWriter().write("<script>alert('添加成功')</script>");
            response.setHeader("refresh", "0;url=/EmployeeList");
        } else {
            //添加失败
            response.getWriter().write("<script>alert('添加失败')</script>");
            response.setHeader("refresh", "0;url=employee_add.jsp");

        }
    }
}

    