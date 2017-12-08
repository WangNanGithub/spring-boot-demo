package com.example.demo.listener.annotation;

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
public class AnnotationRegisterUserEmailListener {
    /**
     * 发送邮件监听实现
     *
     * @param userRegisterEvent 用户注册事件
     */
    @EventListener
    public void sendMail(UserRegisterEvent userRegisterEvent) {
        System.out.println("用户注册成功，发送邮件。");
    }
}
