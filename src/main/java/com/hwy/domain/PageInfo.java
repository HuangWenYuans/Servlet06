/**
 * Copyright (C), 2018
 * FileName: PageInfo
 * Author:   huangwenyuan
 * Date:     2018/12/17 12:31
 * Description:
 */

package com.hwy.domain;

import java.util.List;

/**
 * 功能描述: 实现分页功能的实体类
 *
 * @author huangwenyuan
 * @create 2018/12/17
 * @since 1.0.0
 */
public class PageInfo {
    /***
     * 每页显示的记录数
     */
    private int pageSize;
    /***
     * 当前第几页
     */
    private int pageNumber;
    /***
     * 总页数
     */
    private int pageCount;
    /***
     * 总记录数
     */
    private int recordCount;
    /***
     * 当页显示的数据
     */
    private List<?> list;

    public PageInfo() {
    }

    public PageInfo(int pageSize, int pageNumber, int pageCount, int recordCount, List<?> list) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", pageCount=" + pageCount +
                ", recordCount=" + recordCount +
                ", list=" + list +
                '}';
    }
}

    