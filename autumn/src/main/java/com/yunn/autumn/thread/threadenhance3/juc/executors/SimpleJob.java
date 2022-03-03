package com.yunn.autumn.thread.threadenhance3.juc.executors;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * SimpleJob
 *
 * @author yunN
 * @createTime 2021年02月04日 19:57
 * @description
 */
public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===============================" + System.currentTimeMillis());
    }
}
