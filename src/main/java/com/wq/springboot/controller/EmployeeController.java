package com.wq.springboot.controller;

import com.wq.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wq.springboot.dao.EmployeeDao;

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

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }
}
