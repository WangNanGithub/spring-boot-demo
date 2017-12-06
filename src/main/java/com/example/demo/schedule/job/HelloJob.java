/*
 * Copyright 2016 htouhui.com All right reserved. This software is the
 * confidential and proprietary information of htouhui.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with haitouhui.com.
 */
package com.example.demo.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 * @date 2017年11月30日
 */
public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Quartz!");
    }

}
