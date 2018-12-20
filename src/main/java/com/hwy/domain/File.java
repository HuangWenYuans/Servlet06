/**
 * Copyright (C), 2018
 * FileName: File
 * Author:   huangwenyuan
 * Date:     2018/12/7 13:15
 * Description:
 */

package com.hwy.domain;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/7
 * @since 1.0.0
 */
public class File {
    private int id;
    private String title;
    private String content;
    private String create_time;
    private int is_top;
    private int read_count;
    private String source;
    private String attach;

    public File() {
    }

    public File(int id, String title, String content, String create_time, int is_top, int read_count, String source, String attach) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
        this.is_top = is_top;
        this.read_count = read_count;
        this.source = source;
        this.attach = attach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getRead_count() {
        return read_count;
    }

    public void setRead_count(int read_count) {
        this.read_count = read_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", is_top=" + is_top +
                ", read_count=" + read_count +
                ", source='" + source + '\'' +
                ", attach='" + attach + '\'' +
                '}';
    }
}