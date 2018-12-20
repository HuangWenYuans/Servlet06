package com.hwy.dao;

import com.hwy.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    /***
     * 获取员工总数
     * @return
     */
    int findEmployeeCountDao();

    /***
     * 获取当前页员工的信息
     * @param pageStart
     * @param pageSize
     * @param city
     * @param name
     * @return
     */
    List<Employee> loadPageEmployeeDao(int pageStart, int pageSize, String city, String name);

    /***
     * 添加员工的方法
     * @param name
     * @param work_date
     * @param address
     * @param city
     * @param icon
     * @return
     */
    int addEmployeeDao(String name, String work_date, String address, String city, String icon);

    /***
     * 根据ID删除用户
     * @param id
     * @return
     */
    int deleteEmployeeByIdDao(int id);

    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    Employee loadByEmployeeIdDao(int id);

    /***
     * 根据ID修改员工信息
     * @param id
     * @param name
     * @param work_date
     * @param address
     * @param city
     * @param iconName
     * @return
     */
    int updateEmployeeInformationDao(int id, String name, String work_date, String address, String city, String iconName);


    /***
     *  查询符合搜索条件的记录总数
     * @param pageSize
     * @param pageNumber
     * @param city
     * @param name
     * @return
     */
    int findBlurrySearchEmployeeCountDao(int pageSize, int pageNumber, String city, String name);
}
