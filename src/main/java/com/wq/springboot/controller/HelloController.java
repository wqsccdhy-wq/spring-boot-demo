package com.wq.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wq.springboot.po.Student;

/**
 * @author WQ-Y7000
 * @since 2019-11-12 19:15
 */
@Controller
public class HelloController {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String s = "Hello World！";
        logger.info(s);
        return s;
    }

    @RequestMapping("/success")
    public String success(Model model){
        Student student = new Student();
        student.setId(123);
        student.setName("小米");
        student.setAge(10);
        model.addAttribute("msg", "Thymeleaf语法");
        model.addAttribute("student", student);
        return "thymeleaf/thymeleaf";
    }

}
