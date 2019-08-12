package com.employee.crud;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> employeeList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(0,"小明",20,"男"));
        list.add(new Employee(1, "小红", 19, "女"));
        list.add(new Employee(2, "小智", 15, "男"));
        list.add(new Employee(3, "小钢", 16, "女"));
        list.add(new Employee(4, "小夏", 15, "女"));
        return list;
    }
}
