package com.hwy.service;

import com.hwy.domain.File;
import com.hwy.domain.PageInfo;

public interface FileService {

    /***
     * 根据文件ID获取文件信息
     * @param id
     * @return
     */
    File loadByFileIdService(int id);

    /***
     * 更新文件信息
     * @param id
     * @param title
     * @param content
     * @param create_time
     * @param is_top
     * @param read_count
     * @param source
     * @param attach
     * @return
     */
    int updateFileInformationService(int id, String title, String content, String create_time, int is_top, int read_count, String source, String attach);

    /***
     *实现分页的方法
     * @param pageSize
     * @param pageNumber
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    PageInfo showPage(int pageSize, int pageNumber, String title, String source, String create_time);

    /***
     * 添加文件的方法
     * @return
     */
    int addFileService(String title, String content, String create_time, int is_top, String source, int read_count, String attach);

    /***
     * 根据id删除文件
     *
     * @return
     */
    int deleteByIdService(int id);

}
