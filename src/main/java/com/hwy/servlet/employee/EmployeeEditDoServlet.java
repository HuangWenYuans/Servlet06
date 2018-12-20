/**
 * Copyright (C), 2018
 * FileName: EmployeeEditDoServlet
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:13
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
public class EmployeeEditDoServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            //如果上传了文件的话，使用新的文件
            if (smartFile.getFileName() != null && !"".equals(smartFile.getFileName())) {
                //生成唯一的uuid
                String uuid = UUID.randomUUID().toString();
                //截取文件的后缀名
                String suffix = smartFile.getFileName().substring(smartFile.getFileName().lastIndexOf("."));
                //文件名
                iconName = uuid + suffix;
                smartFile.saveAs("/employeeIcon/" + iconName);
            } else {
                //如果没上传文件则使用原来的文件
                iconName = su.getRequest().getParameter("iconName");
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取请求信息
        int id = Integer.parseInt(su.getRequest().getParameter("id"));
        String name = su.getRequest().getParameter("name");
        String work_date = su.getRequest().getParameter("work_date");
        String address = su.getRequest().getParameter("address");
        String city = su.getRequest().getParameter("city");


        //调用更新文件的方法
        int index = employeeService.updateEmployeeInformationService(id, name, work_date, address, city, iconName);
        if (index > 0) {
            //更新完成,进行跳转
            response.getWriter().write("<script type=text/javascript> alert('数据修改成功！')</script>");
        } else {
            //    更新失败
            response.getWriter().write("<script type=text/javascript> alert('数据修改失败！')</script>");
        }
        response.setHeader("refresh", "0;url=/EmployeeList");
    }

}

    