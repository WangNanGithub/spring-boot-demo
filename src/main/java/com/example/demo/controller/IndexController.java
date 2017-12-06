package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "get index success";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "不验证哦";
    }

}
