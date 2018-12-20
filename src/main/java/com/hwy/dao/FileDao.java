package com.hwy.dao;

import com.hwy.domain.File;

import java.util.List;

public interface FileDao {
    /***
     * 根据文件ID查询文件信息
     * @param id
     * @return
     */
    File loadByFileIdDao(int id);

    /***
     * 更新用户信息
     * @param id
     * @param title
     * @param content
     * @param create_time
     * @param is_top
     * @param read_count
     * @param source
     * @return
     */
    int updateFileInformationDao(int id, String title, String content, String create_time, int is_top, int read_count, String source, String attach);

    /***
     *  获取文件总数
     * @return 文件的总数
     */
    int findFileCountDao();

    /***
     * 获取当前页显示的数据
     * @param pageStart
     * @param pageSize
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    List<File> loadPageFileDao(int pageStart, int pageSize, String title, String source, String create_time);

    /***
     * 添加文件的方法
     * @return
     */
    int addFileDao(String title, String content, String create_time, int is_top, String source, int read_count, String attach);

    /***
     * 根据id删除文件
     * @param id
     * @return
     */
    int deleteByIdDao(int id);

    /***
     * 获取符合搜索条件的记录总数
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    int findBlurrySearchFileCountDao(String title, String source, String create_time);
}
