package com.yunn.autumnnacos.service.impl;

import com.yunn.autumnnacos.model.YmlProps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @author yunN
 * @date 2022/07/13
 */
@SpringBootTest
@RunWith(value = SpringRunner.class)
public class TranscationLearnServiceTest {

    @Autowired
    TranscationLearnService transcationLearnService;

    @Autowired
    YmlProps ymlProps;

    long pre = Long.MIN_VALUE;

    @Test
    public void test() {
        transcationLearnService.haveNestedTransaction();
    }

    @Test
    public void testReadYmlProps() {
        Set<String> set = transcationLearnService.readYmlProps();
        String serach = "Cn";
        System.out.println(set.stream().anyMatch(serach::equalsIgnoreCase));
    }

    @Test
    public void testYmlProps() {
        Set<String> vals = ymlProps.getValsTry();
        vals.forEach(System.out::println);
    }

}
