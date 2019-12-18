package com.wq.springboot.controller;

import com.wq.springboot.dao.DepartmentDao;
import com.wq.springboot.dao.EmployeeDao;
import com.wq.springboot.entities.Department;
import com.wq.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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

    /**
     * 获取所有员工
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    /**
     * 添加员工页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String addPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    /**
     * 修改员工页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(Model model,@PathVariable("id") Integer id){
        //employeeDao.save(employee);
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    /**
     * 更新员工
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
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
