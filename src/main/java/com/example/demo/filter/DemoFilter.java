/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年11月29日
 */
@WebFilter(urlPatterns = "/*", filterName = "demoFilter")
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("==>DemoFilter启动");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        StringBuffer url = httpServletRequest.getRequestURL();
        System.out.println("==>DemoFilter拦截请求 : " + url);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
