package com.example.demo.timers;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 商品库存检查定时任务
 * ========================
 *
 * @author 恒宇少年
 * Created with IntelliJ IDEA.
 * Date：2017/11/5
 * Time：15:47
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Slf4j
public class GoodStockCheckTimer extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("分布式节点quartz-cluster-node-first，执行库存检查定时任务，执行时间：{}", new Date());
    }
}
