/**
 * Copyright (C), 2018
 * FileName: FileListServlet
 * Author:   huangwenyuan
 * Date:     2018/12/17 10:56
 * Description:
 */

package com.hwy.servlet.file;

import com.hwy.domain.PageInfo;
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
public class FileListServlet extends HttpServlet {
    FileService fileService = new FileServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求信息
        String title = request.getParameter("title");
        String source = request.getParameter("source");
        String create_time = request.getParameter("create_time");
        //对未输入模糊查询条件的情况进行处理
        if (title == null) {
            title = "";
        }
        if (source == null) {
            source = "";
        }
        if (create_time == null) {
            create_time = "";
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
        PageInfo pi = fileService.showPage(pageSize, pageNumber, title, source, create_time);
        request.setAttribute("pageInfo", pi);
        request.setAttribute("title", title);
        request.setAttribute("source", source);
        request.setAttribute("create_time", create_time);
        request.getRequestDispatcher("file/file_list.jsp").forward(request, response);


    }
}

    