package com.yunn.autumnnacos.service.impl;

import com.yunn.autumnnacos.mapper.TranscationMapper;
import com.yunn.autumnnacos.model.GroupDo;
import com.yunn.autumnnacos.model.GroupVo;
import com.yunn.autumnnacos.model.TranscationLearnDo;
import com.yunn.autumnnacos.model.YmlProps;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author yunN
 * @date 2022/07/13
 */
@Service
@RequiredArgsConstructor
public class TransactionalLearnService {

    private final TranscationMapper transcationMapper;

    @Value("#{'${test.val}'.split(',')}")
    private final List<String> vals;

    private final YmlProps ymlProps;

    @Transactional(rollbackFor = Exception.class)
    public void haveNestedTransaction() {
        TranscationLearnDo t1 = TranscationLearnDo.builder().name("t1-5").build();
        t1.setId(5);
        TranscationLearnDo t2 = TranscationLearnDo.builder().name("t2").build();
        transcationMapper.save(t1);
        transcationMapper.save(t2);
        List<TranscationLearnDo> rs = transcationMapper.findAll();
        haveOwnTranscation();
        System.out.println(rs.isEmpty());
    }

    @Transactional(rollbackFor = Exception.class)
    public void haveOwnTranscation() {
        TranscationLearnDo t3 = TranscationLearnDo.builder().name("t3").build();
        TranscationLearnDo t4 = TranscationLearnDo.builder().name("t3").build();
        transcationMapper.save(t3);
        transcationMapper.save(t4);
    }

    public Set<String> readYmlProps() {
        return ymlProps.getValsTry();
    }

    public List<GroupVo> convertDO2Vo() {

        List<GroupDo> groupDo = getGroupDos();
        List<GroupVo> ans = new ArrayList<>();
        for (GroupDo g : groupDo) {
            GroupVo t = new GroupVo();
            GroupVo groupDTO = t.convertFrom(g);
            ans.add(groupDTO);

        }
        return ans;
    }

    private List<GroupDo> getGroupDos() {
        GroupDo groupDo = new GroupDo();
        groupDo.setName("n1");
        groupDo.setX(1L);
        GroupDo groupDo2 = new GroupDo();
        groupDo2.setName("n2");
        groupDo2.setX(2L);
        GroupDo groupDo3 = new GroupDo();
        groupDo3.setName("n3");
        groupDo3.setX(3L);
        return Arrays.asList(groupDo, groupDo2, groupDo3);
    }

    private List<GroupVo> getGroupVos() {
        GroupVo groupVo = new GroupVo();
        groupVo.setName("n1");
        groupVo.setX(1L);
        GroupVo groupVo2 = new GroupVo();
        groupVo2.setName("n2");
        groupVo2.setX(2L);
        GroupVo groupVo3 = new GroupVo();
        groupVo3.setName("n3");
        groupVo3.setX(3L);
        return Arrays.asList(groupVo, groupVo2, groupVo3);
    }
}
