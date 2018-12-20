package com.hwy.service;

import com.hwy.domain.Employee;
import com.hwy.domain.PageInfo;

public interface EmployeeService {

    /***
     * 实现分页的方法
     * @param pageStart
     * @param pageSize
     * @param city
     * @param name
     * @return
     */
    PageInfo showPage(int pageStart, int pageSize, String city, String name);

    /***
     * 添加员工的方法
     * @param name
     * @param work_date
     * @param address
     * @param city
     * @param icon
     * @return
     */
    int addEmployeeService(String name, String work_date, String address, String city, String icon);

    /***
     * 根据ID删除员工
     * @param id
     * @return
     */
    int deleteEmployeeByIdService(int id);

    /***
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    Employee loadByEmployeeIdService(int id);

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
    int updateEmployeeInformationService(int id, String name, String work_date, String address, String city, String iconName);
}
