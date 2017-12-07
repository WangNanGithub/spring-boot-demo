/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.handler;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static com.example.demo.util.IpUtil.getIpAddress;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月06日
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private final UserJPA usersRepository;

    @Autowired
    public LoginSuccessHandler(UserJPA usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * 登陆成功后的页面转发
     */
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        saveLoginInfo(request, authentication);

        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /**
     * 刷新用户登录信息
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void saveLoginInfo(HttpServletRequest request, Authentication authentication) {
        UserEntity user = (UserEntity) authentication.getPrincipal();
        try {
            String ip = getIpAddress(request);
            Date date = new Date();
            user.setLastLogin(date);
            user.setLoginIp(ip);
            usersRepository.saveAndFlush(user);
        } catch (DataAccessException e) {
            if (logger.isWarnEnabled()) {
                logger.info("无法更新用户登录信息至数据库");
            }
        }
    }

    /**
     * 不同的角色登陆成功后跳转到不同的页面
     */
    private String determineTargetUrl(Authentication authentication) {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();
        authorities.forEach(x -> roles.add(x.getAuthority()));

        String url;
        if (roles.contains("ROLE_DBA")) {
            url = "/db";
        } else if (roles.contains("ROLE_ADMIN")) {
            url = "/admin";
        } else if (roles.contains("ROLE_USER")) {
            url = "/home";
        } else {
            url = "/accessDenied";
        }
        return url;
    }
}
