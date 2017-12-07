/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年12月07日
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    //用户名
    private String name;
    //密码
    private String pwd;
}
