/**
 * Copyright (C), 2018
 * FileName: EmployeeServiceImpl
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:15
 * Description:
 */

package com.hwy.service.Impl;

import com.hwy.dao.EmployeeDao;
import com.hwy.dao.Impl.EmployeeDaoImpl;
import com.hwy.domain.Employee;
import com.hwy.domain.PageInfo;
import com.hwy.service.EmployeeService;

import java.util.List;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/19
 * @since 1.0.0
 */
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao ed = new EmployeeDaoImpl();

    /***
     * 实现分页的方法
     * @param pageSize
     * @param pageNumber
     * @param city
     * @param name
     * @return
     */
    @Override
    public PageInfo showPage(int pageSize, int pageNumber, String city, String name) {
        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        //获取符合搜索条件的总记录数
        int recordCount = ed.findBlurrySearchEmployeeCountDao(pageSize, pageNumber, city, name);
        //    获取当前页显示的数据
        List<Employee> employeeList = ed.loadPageEmployeeDao(pageSize * (pageNumber - 1), pageSize, city, name);
        pi.setList(employeeList);
        //总页数
        int pageCount = (int) Math.ceil(recordCount * 1.0 / pageSize);
        //int pageCount = (recordCount % pageSize == 0 ? recordCount / pageSize : recordCount / pageSize + 1);
        pi.setPageCount(pageCount);
        pi.setRecordCount(recordCount);
        return pi;
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
    public int addEmployeeService(String name, String work_date, String address, String city, String icon) {
        return ed.addEmployeeDao(name, work_date, address, city, icon);
    }

    /***
     * 根据ID删除员工
     * @param id
     * @return
     */
    @Override
    public int deleteEmployeeByIdService(int id) {
        return ed.deleteEmployeeByIdDao(id);
    }

    /***
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @Override
    public Employee loadByEmployeeIdService(int id) {
        return ed.loadByEmployeeIdDao(id);
    }

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
    @Override
    public int updateEmployeeInformationService(int id, String name, String work_date, String address, String city, String iconName) {
        return ed.updateEmployeeInformationDao(id, name, work_date, address, city, iconName);
    }
}

    