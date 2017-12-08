/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.listener.annotation;

import com.example.demo.bean.UserBean;
import com.example.demo.event.UserRegisterEvent;
import org.springframework.context.event.EventListener;

/**
 * 注册监听实现方法 (注解实现)
 * [执行顺序不固定, 随机执行]
 *
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月08日
 */
//@Component
public class AnnotationRegisterYListener {

    /**
     * 注册监听实现方法
     *
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void register(UserRegisterEvent userRegisterEvent) {

        //获取注册用户对象
        UserBean user = userRegisterEvent.getUser();

        //../省略逻辑

        //输出注册用户信息
        System.out.println("@EventListener注册信息，用户名：" + user.getName() + "，密码：" + user.getPassword());
    }

}
