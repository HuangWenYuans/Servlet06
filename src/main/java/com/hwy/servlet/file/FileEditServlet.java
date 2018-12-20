/**
 * Copyright (C), 2018
 * FileName: FileEditServlet
 * Author:   huangwenyuan
 * Date:     2018/12/7 12:57
 * Description:
 */

package com.hwy.servlet.file;

import com.hwy.service.FileService;
import com.hwy.service.Impl.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/7
 * @since 1.0.0
 */
public class FileEditServlet extends HttpServlet {
    FileService fileService = new FileServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //    获取请求信息
        //获取文件id
        int id = Integer.parseInt(request.getParameter("id"));
        com.hwy.domain.File f = fileService.loadByFileIdService(id);
        //将file对象传给file_edit.jsp
        request.setAttribute("file", f);
        //请求转发
        request.getRequestDispatcher("file/file_edit.jsp").forward(request, response);
     }
}

    