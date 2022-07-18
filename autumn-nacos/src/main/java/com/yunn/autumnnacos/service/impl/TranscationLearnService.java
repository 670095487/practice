package com.yunn.autumnnacos.service.impl;

import com.yunn.autumnnacos.mapper.TranscationMapper;
import com.yunn.autumnnacos.model.TranscationLearnDo;
import com.yunn.autumnnacos.model.YmlProps;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yunN
 * @date 2022/07/13
 */
@Service
@RequiredArgsConstructor
public class TranscationLearnService {

    private final TranscationMapper transcationMapper;

    @Value("#{'${test.val}'.split(',')}")
    private final List<String> vals;

    private final YmlProps ymlProps;

    @Transactional(rollbackFor = Exception.class)
    public void haveNestedTransaction() {
        TranscationLearnDo t1 = TranscationLearnDo.builder().name("t1").build();
        TranscationLearnDo t2 = TranscationLearnDo.builder().name("t2").build();
        transcationMapper.save(t1);
        transcationMapper.save(t2);
        haveOwnTranscation();
        transcationMapper.findAll().forEach(System.out::println);
    }

    @Transactional(rollbackFor = Exception.class)
    public void haveOwnTranscation() {
        TranscationLearnDo t3 = TranscationLearnDo.builder().name("t3").build();
        TranscationLearnDo t4 = TranscationLearnDo.builder().name("t3").build();
        transcationMapper.save(t3);
        transcationMapper.save(t4);
    }

    public void readYmlProps() {
        // vals.forEach(System.out::println);
        ymlProps.getVals().forEach(System.out::println);
    }

}
