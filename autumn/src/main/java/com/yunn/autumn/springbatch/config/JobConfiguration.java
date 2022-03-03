package com.yunn.autumn.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JobConfiguration
 *
 * @Author: yunN
 * @CreateTime: 2020/07/30
 * @Description: springbatch的任务配置类
 */
@Configuration
@EnableBatchProcessing //启用批处理
public class JobConfiguration {

    /**
     * 注入任务工厂类对象
     */
    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    /**
     * 任务的执行由step决定，每一步做什么
     * 注入创建step的对象
     */
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    /**
     * 创建任务对象
     */
    @Bean
    public Job demoJob() {
        //任务名称
        return jobBuilderFactory.get("demoJob")
                //开始执行步骤1
                .start(step1())
                .build();
    }

    /**
     * 步骤一的具体实现
     *
     * @return
     */
    private Step step1() {
        //步骤名
        return stepBuilderFactory.get("step1")
                //具体任务
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        //业务逻辑fu
                        System.out.println("模拟执行类业务逻辑");
                        //返回执行成功的标识，下一步会根据此状态来决定是否进行下一步
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}


//说实话 我现在也不知道让我崩溃的究竟是硬件还是学识，或许多少有点学识配不上硬件的感觉，过于追求物质上的享受，从而忽略了自身学识的欠缺，
//导致自身的问题影响到了生活以及工作，以后一定要想清楚，自己究竟要的是什么，然后再去努力一把，会比盲目的去做，去追求好很多。
//--0801凌晨1点于上海