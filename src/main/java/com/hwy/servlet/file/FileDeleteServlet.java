/**
 * Copyright (C), 2018
 * FileName: FileDeleteServlet
 * Author:   huangwenyuan
 * Date:     2018/12/17 10:57
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
 * @create 2018/12/17
 * @since 1.0.0
 */
public class FileDeleteServlet extends HttpServlet {
    FileService fileService = new FileServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = fileService.deleteByIdService(id);
        if (index > 0) {
            //    删除成功
            response.getWriter().print("<script>alert('删除成功!')</script>");
        } else {
            //删除失败
            response.getWriter().print("<script>alert('删除失败!')</script>");
        }
        response.setHeader("refresh", "0;url=/FileList");
    }
}

    