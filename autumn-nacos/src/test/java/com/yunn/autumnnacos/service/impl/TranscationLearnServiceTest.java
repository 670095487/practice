package com.yunn.autumnnacos.service.impl;

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
    TransactionalLearnService transactionalLearnService;

    @Test
    public void test() {
        transactionalLearnService.haveNestedTransaction();
    }

    @Test
    public void testReadYmlProps() {
        transactionalLearnService.readYmlProps();
    }

}
