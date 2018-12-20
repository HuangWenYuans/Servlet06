/**
 * Copyright (C), 2018
 * FileName: EmployeeDaoImpl
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:29
 * Description:
 */

package com.hwy.dao.Impl;

import com.hwy.dao.EmployeeDao;
import com.hwy.domain.Employee;
import com.hwy.domain.File;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/19
 * @since 1.0.0
 */
public class EmployeeDaoImpl implements EmployeeDao {
    /***
     * 获取员工总数
     * @return
     */
    @Override
    public int findEmployeeCountDao() {
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
            String sql = "select count(*) from employee";
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
     * 获取当前页员工的信息
     * @param pageStart
     * @param pageSize
     * @param city
     * @param name
     * @return
     */
    @Override
    public List<Employee> loadPageEmployeeDao(int pageStart, int pageSize, String city, String name) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        city = "%" + city + "%";
        name = "%" + name + "%";
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "select top(?)* from employee where id not in(select top(?) id from employee order by work_date desc)" +
                    " and city like ? and name like ?  order by work_date desc";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1, pageSize);
            ps.setInt(2, pageStart);
            ps.setString(3, city);
            ps.setString(4, name);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()) {
                //给变量赋值
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setIcon(rs.getString("icon"));
                employee.setName(rs.getString("name"));
                employee.setWork_date(rs.getString("work_date"));
                employee.setAddress(rs.getString("address"));
                employee.setCity(rs.getString("city"));
                employeeList.add(employee);
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
        return employeeList;
    }

    /***
     * 添加员工的方法
     * @param name
     * @param work_date
     * @param address
     * @param city
     * @param icon
     * @return
     */
    @Override
    public int addEmployeeDao(String name, String work_date, String address, String city, String icon) {
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
            String sql = "insert into employee(name,work_date,address,city,icon) values(?,?,?,?,?)";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, name);
            ps.setString(2, work_date);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, icon);
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
     * 根据ID删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteEmployeeByIdDao(int id) {
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
            String sql = "delete from employee where id = ?";
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
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public Employee loadByEmployeeIdDao(int id) {
        //声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明变量
        Employee employee = null;
        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //创建sql命令
            String sql = "select * from employee where id = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setInt(1, id);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果
            while (rs.next()) {
                //给变量赋值
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setWork_date(rs.getString("work_date"));
                employee.setAddress(rs.getString("address"));
                employee.setCity(rs.getString("city"));
                employee.setIcon(rs.getString("icon"));
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
        return employee;

    }

    /***
     * 根据ID修改员工信息
     * @param id
     * @param name
     * @param work_date
     * @param create_time
     * @param address
     * @param city
     * @param iconName
     * @return
     */
    @Override
    public int updateEmployeeInformationDao(int id, String name, String work_date, String address, String city, String iconName) {
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
            String sql = "update employee set name = ?, work_date = ?, address = ?, city = ?,icon = ? where id = ?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, name);
            ps.setString(2, work_date);
            ps.setString(3, address);
            ps.setString(4, city);
            ps.setString(5, iconName);
            ps.setInt(6, id);
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
     *  查询符合搜索条件的记录总数
     * @param pageSize
     * @param pageNumber
     * @param city
     * @param name
     * @return
     */
    @Override
    public int findBlurrySearchEmployeeCountDao(int pageSize, int pageNumber, String city, String name) {
        //    声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //    声明变量
        int count = 0;
        city = "%" + city + "%";
        name = "%" + name + "%";
        try {
            //   加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            //    获取连接
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=oa";
            conn = DriverManager.getConnection(url, "user", "user");
            //    创建sql命令
            String sql = "select count(*) from employee where city like ? and name like ?";
            //    创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1, city);
            ps.setString(2, name);
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

    