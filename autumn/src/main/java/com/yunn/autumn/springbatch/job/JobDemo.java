package com.yunn.autumn.springbatch.job;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * JobDemo
 *
 * @Author: yunN
 * @CreateTime: 2020/08/01
 * @Description:
 */
@Configuration
@EnableBatchProcessing
public class JobDemo {

    @Resource
    private JobBuilderFactory jobBuilderFactory;

    @Resource
    private StepBuilderFactory stepBuilderFactory;


}
