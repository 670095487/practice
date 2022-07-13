package com.yunn.autumnnacos.service.impl;

import com.yunn.autumnnacos.mapper.TranscationMapper;
import com.yunn.autumnnacos.model.TranscationLearnDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yunN
 * @date 2022/07/13
 */
@Service
@RequiredArgsConstructor
public class TranscationLearnService {

    private final TranscationMapper transcationMapper;

    @Transactional(rollbackFor = Exception.class)
    public void haveNestedTransaction() {
        TranscationLearnDo t1 = TranscationLearnDo.builder().name("t1").build();
        TranscationLearnDo t2 = TranscationLearnDo.builder().name("t2").build();
        transcationMapper.save(t1);
        transcationMapper.save(t2);
        // int a = 1/0;
        haveOwnTranscation();
    }

    @Transactional(rollbackFor = Exception.class)
    public void haveOwnTranscation() {
        TranscationLearnDo t3 = TranscationLearnDo.builder().name("t3").build();
        // int a = 1 / 0;
        TranscationLearnDo t4 = TranscationLearnDo.builder().name("t3").build();
        transcationMapper.save(t3);
        transcationMapper.save(t4);
    }

}
