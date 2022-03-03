package com.yunn.autumn.someproduction.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by yunN on 2021/06/26.
 */
public interface RealHandler extends InitializingBean {

    /**
     *
     * @throws Exception .
     */
    @Override
    void afterPropertiesSet() throws Exception;
}
