/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月06日
 */
@Controller
public class DemoController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private String url;

    @RequestMapping("/home")
    public String homePage(ModelMap model, HttpServletRequest request) {
        url = request.getRequestURL().toString();
        model.addAttribute("user", getPrincipal());
        return "home";
    }

    @RequestMapping("/admin")
    public String adminPage(ModelMap model, HttpServletRequest request) {
        url = request.getRequestURL().toString();
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping("/access_denied")
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        model.addAttribute("url", url);
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
            LOGGER.info("User login name : {}", userName);
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
