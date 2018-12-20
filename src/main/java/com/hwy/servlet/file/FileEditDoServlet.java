/**
 * Copyright (C), 2018
 * FileName: FileEditDoServlet
 * Author:   huangwenyuan
 * Date:     2018/12/7 13:09
 * Description:
 */

package com.hwy.servlet.file;

import com.hwy.service.FileService;
import com.hwy.service.Impl.FileServiceImpl;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
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
 * @create 2018/12/7
 * @since 1.0.0
 */
public class FileEditDoServlet extends HttpServlet {
    FileService fileService = new FileServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/") + "/upload";
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
        //su.setAllowedFilesList("txt,jpg,gif,png");
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
        String attachName = null;
        try {
            //如果上传了文件的话，说明用户需要更改上传的文件则使用新上传的文件
            if (smartFile.getFileName() != null && !"".equals(smartFile.getFileName())) {
                //生成唯一的uuid
                String uuid = UUID.randomUUID().toString();
                //截取文件的后缀名
                String suffix = smartFile.getFileName().substring(smartFile.getFileName().lastIndexOf("."));
                //文件名
                attachName = uuid + suffix;
                smartFile.saveAs("/upload/" + attachName);
            } else {
                //    如果没上传文件的话，则使用旧文件的文件名
                attachName = su.getRequest().getParameter("attachName");
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        //获取请求信息
        int id = Integer.parseInt(su.getRequest().getParameter("id"));
        //获取文件信息
        String title = su.getRequest().getParameter("title");
        String content = su.getRequest().getParameter("content");
        String create_time = su.getRequest().getParameter("create_time");
        int is_top = Integer.parseInt(su.getRequest().getParameter("is_top"));
        String source = su.getRequest().getParameter("source");
        int read_count = 0;
        //调用更新文件的方法
        int index = fileService.updateFileInformationService(id, title, content, create_time, is_top, read_count, source, attachName);
        if (index > 0) {
            //更新完成,进行跳转
            response.getWriter().write("<script type=text/javascript> alert('数据修改成功！')</script>");
        } else {
            //    更新失败
            response.getWriter().write("<script type=text/javascript> alert('数据修改失败！')</script>");
        }
        response.setHeader("refresh", "0;url=/FileList");
    }
}

    