/**
 * Copyright (C), 2018
 * FileName: Employee
 * Author:   huangwenyuan
 * Date:     2018/12/19 9:33
 * Description:
 */

package com.hwy.domain;

/**
 * 功能描述:
 *
 * @author huangwenyuan
 * @create 2018/12/19
 * @since 1.0.0
 */
public class Employee {
    private int id;
    private String icon;
    private String name;
    private String work_date;
    private String address;
    private String city;

    public Employee() {
    }

    public Employee(int id, String icon, String name, String work_date, String address, String city) {

        this.id = id;
        this.icon = icon;
        this.name = name;
        this.work_date = work_date;
        this.address = address;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork_date() {
        return work_date;
    }

    public void setWork_date(String work_date) {
        this.work_date = work_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", work_date='" + work_date + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

    