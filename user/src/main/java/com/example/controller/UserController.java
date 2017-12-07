/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.controller;

import com.example.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月07日
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user/index")
    public String index(HttpServletRequest request, UserBean user) {

        //将name属性传入到user_index.jsp页面中展示
        request.setAttribute("name", user.getName());
        //跳转user_index.jsp页面
        return "user_index";
    }

}
