/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月07日
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        System.out.println(ResourceUtils.CLASSPATH_URL_PREFIX);
        return "This is a CORS request";
    }

}
