/**
 * Copyright (C), 2018
 * FileName: FileDownloadServlet
 * Author:   huangwenyuan
 * Date:     2018/12/17 21:14
 * Description:
 */

package com.hwy.servlet.file;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

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
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("name");
        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);
        su.setContentDisposition(null);

        try {
            su.downloadFile("/upload/" + fileName);
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

    }
}

    