package com.wq.springboot.controller;

import com.wq.springboot.dao.DepartmentDao;
import com.wq.springboot.dao.EmployeeDao;
import com.wq.springboot.entities.Department;
import com.wq.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @author wangqing
 * @Desc
 * @Date: 2019-12-17 20:34
 * @since 2019/12/17 20:34
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

//    @PostMapping("/emp")
//    public String addEmp(Employee employee){
//        employeeDao.save(employee);
//        return "forward:/emps";
//    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        //保存员工
        employeeDao.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }
}
