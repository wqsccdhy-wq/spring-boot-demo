package com.wq.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WQ-Y7000
 * @since 2019-11-12 19:15
 */
@RestController
public class HelloController {

    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("hello")
    public String hello() {
        String s = "Hello World！";
        logger.info(s);
        return s;
    }

}
