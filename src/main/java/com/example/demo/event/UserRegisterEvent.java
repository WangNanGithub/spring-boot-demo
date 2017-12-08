/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.event;

import com.example.demo.bean.UserBean;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月08日
 */
public class UserRegisterEvent extends ApplicationEvent {

    //注册用户对象
    @Getter
    private UserBean user;

    /**
     * 重写构造函数
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public UserRegisterEvent(Object source, UserBean user) {
        super(source);
        this.user = user;
    }
}
