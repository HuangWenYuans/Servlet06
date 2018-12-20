/**
 * Copyright (C), 2018
 * FileName: FileServiceImpl
 * Author:   huangwenyuan
 * Date:     2018/12/7 13:31
 * Description:
 */

package com.hwy.service.Impl;

import com.hwy.dao.FileDao;
import com.hwy.dao.Impl.FileDaoImpl;
import com.hwy.domain.File;
import com.hwy.domain.PageInfo;
import com.hwy.service.FileService;

import java.util.List;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/7
 * @since 1.0.0
 */
public class FileServiceImpl implements FileService {
    FileDao fd = new FileDaoImpl();

    /***
     * 根据文件ID获取文件信息
     * @param id
     * @return
     */
    @Override
    public File loadByFileIdService(int id) {
        return fd.loadByFileIdDao(id);
    }

    /***
     * 更新文件信息
     * @param id
     * @param title
     * @param content
     * @param create_time
     * @param is_top
     * @param read_count
     * @param source
     * @return
     */
    @Override
    public int updateFileInformationService(int id, String title, String content, String create_time, int is_top, int read_count, String source, String attach) {

        return fd.updateFileInformationDao(id, title, content, create_time, is_top, read_count, source, attach);
    }

    /***
     *实现分页的方法
     * @param pageSize
     * @param pageNumber
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    @Override
    public PageInfo showPage(int pageSize, int pageNumber, String title, String source, String create_time) {
        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        //获取符合搜索条件的总记录数
        int recordCount = fd.findBlurrySearchFileCountDao(title, source,create_time);
        //    获取当前页显示的数据
        List<File> fileList = fd.loadPageFileDao(pageSize * (pageNumber - 1), pageSize, title, source, create_time);
        pi.setList(fileList);
        int pageCount = (int) Math.ceil(recordCount * 1.0 / pageSize);
        //int pageCount = (recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
        pi.setPageCount(pageCount);
        pi.setRecordCount(recordCount);
        return pi;
    }

    /***
     * 添加文件的方法
     * @return
     * @param title
     * @param content
     * @param create_time
     * @param is_top
     * @param source
     * @param read_count
     * @param attach
     */
    @Override
    public int addFileService(String title, String content, String create_time, int is_top, String source, int read_count, String attach) {
        return fd.addFileDao(title, content, create_time, is_top, source, read_count, attach);
    }

    /***
     * 根据id删除文件
     *
     * @return
     * @param id
     */
    @Override
    public int deleteByIdService(int id) {
        return fd.deleteByIdDao(id);
    }
}

    