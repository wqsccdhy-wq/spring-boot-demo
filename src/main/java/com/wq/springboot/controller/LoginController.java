package com.wq.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author wq-z170
 * @since 2019/12/15 17:16
 * @Desc 登录模块
 */
@Controller
public class LoginController {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
        Map<String, String> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("user", username);
            // 登陆成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或者密码错误");
            return "login";
        }

    }
}
