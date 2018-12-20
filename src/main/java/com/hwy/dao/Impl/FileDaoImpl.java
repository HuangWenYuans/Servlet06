/**
 * Copyright (C), 2018
 * FileName: FileDaoImpl
 * Author:   huangwenyuan
 * Date:     2018/12/7 13:20
 * Description:
 */

package com.hwy.dao.Impl;

import com.hwy.dao.FileDao;
import com.hwy.domain.File;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/7
 * @since 1.0.0
 */
public class FileDaoImpl implements FileDao {
    /***
     * 根据文件ID查询文件信息
     * @param id
     * @return
     */
    @Override
    public File loadByFileIdDao(int id) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        File f = null;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "select * from TFile where id = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1, id);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()) {
                f = new File();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("title"));
                f.setContent(rs.getString("content"));
                f.setCreate_time(rs.getString("create_time"));
                f.setIs_top(rs.getInt("is_top"));
                f.setRead_count(rs.getInt("read_count"));
                f.setSource(rs.getString("source"));
                f.setAttach(rs.getString("attach"));
            }
            //给变量赋值
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        //返回结果
        return f;
    }

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
    @Override
    public int updateFileInformationDao(int id, String title, String content, String create_time, int is_top, int read_count, String source, String attach) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        //声明变量
        int index = -1;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "update TFile set title = ?, content = ?, create_time = ?, is_top = ?,source = ?,attach = ? where id = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, create_time);
            ps.setInt(4, is_top);
            ps.setString(5, source);
            ps.setString(6, attach);
            ps.setInt(7, id);

            //执行sql
            index = ps.executeUpdate();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回结果
        return index;
    }

    /***
     *  获取文件总数
     * @return 文件的总数
     */
    @Override
    public int findFileCountDao() {
        //    声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //    声明变量
        int count = 0;
        try {
            //   加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //    获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //    创建sql命令
            String sql = "select count(*) from TFile";
            //    创建sql命令对象
            ps = conn.prepareStatement(sql);
            //    执行sql
            rs = ps.executeQuery();
            //    遍历结果
            while (rs.next()) {
                //    给变量赋值
                count = rs.getInt(1);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //    关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //    返回结果
        return count;
    }

    /***
     * 获取当前页显示的数据
     * @param pageStart
     * @param pageSize
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    @Override
    public List<File> loadPageFileDao(int pageStart, int pageSize, String title, String source, String create_time) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        List<File> fileList = new ArrayList<>();
        File f = null;
        title = "%" + title + "%";
        source = "%" + source + "%";
        create_time = "%" + create_time + "%";
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "select top(?)* from TFile where id not in(select top(?) id from TFile order by is_top desc,create_time desc)" +
                    " and title like ? and source like ? and create_time like ?  order by is_top desc,create_time desc";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1, pageSize);
            ps.setInt(2, pageStart);
            ps.setString(3, title);
            ps.setString(4, source);
            ps.setString(5, create_time);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()) {
                //给变量赋值
                f = new File();
                f.setId(rs.getInt("id"));
                f.setTitle(rs.getString("title"));
                f.setContent(rs.getString("content"));
                f.setCreate_time(rs.getString("create_time"));
                f.setIs_top(rs.getInt("is_top"));
                f.setRead_count(rs.getInt("read_count"));
                f.setSource(rs.getString("source"));
                f.setAttach(rs.getString("attach"));
                fileList.add(f);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回结果
        return fileList;
    }


    /***
     * 添加文件的方法
     * @return
     */
    @Override
    public int addFileDao(String title, String content, String create_time, int is_top, String source, int read_count, String attach) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        int index = -1;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "insert into TFile(title,content,create_time,is_top,source,read_count,attach) values(?,?,?,?,?,?,?)";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, create_time);
            ps.setInt(4, is_top);
            ps.setString(5, source);
            ps.setInt(6, read_count);
            ps.setString(7, attach);
            //执行sql
            index = ps.executeUpdate();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源

        }
        //返回结果
        return index;
    }

    /***
     * 根据id删除文件
     * @param id
     * @return
     */
    @Override
    public int deleteByIdDao(int id) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        //声明变量
        int index = -1;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "delete from TFile where id = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1, id);
            //执行sql
            index = ps.executeUpdate();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回结果
        return index;
    }

    /***
     * 获取符合搜索条件的记录总数
     * @param title
     * @param source
     * @param create_time
     * @return
     */
    @Override
    public int findBlurrySearchFileCountDao(String title, String source, String create_time) {
        //    声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //    声明变量
        int count = 0;
        title = "%" + title + "%";
        source = "%" + source + "%";
        create_time = "%" + create_time + "%";
        try {
            //   加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //    获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //    创建sql命令
            String sql = "select count(*) from TFile where title like ? and source like ? and create_time like ? ";
            //    创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, title);
            ps.setString(2, source);
            ps.setString(3, create_time);
            //    执行sql
            rs = ps.executeQuery();
            //    遍历结果
            while (rs.next()) {
                //    给变量赋值
                count = rs.getInt(1);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //    关闭资源
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //    返回结果
        return count;
    }
}

    