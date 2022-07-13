package com.yunn.autumnnacos.service.impl;

import com.yunn.autumnnacos.NacosLearnApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yunN
 * @date 2022/07/13
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class TranscationLearnServiceTest {

    @Autowired
    TranscationLearnService transcationLearnService;

    @Test
    public void test() {
        transcationLearnService.haveNestedTransaction();
    }

}
