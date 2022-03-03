package com.yunn.autumn.thread.threadenhance3.juc.executors;

import org.junit.Test;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

/**
 * QuartzSchedule
 *
 * @author yunN
 * @createTime 2021年02月04日 19:56
 * @description
 */
public class QuartzSchedule {

    public static void main(String[] args) {
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("Job1", "Group1").build();


    }

    @Test
    public void test() {
    }

}
