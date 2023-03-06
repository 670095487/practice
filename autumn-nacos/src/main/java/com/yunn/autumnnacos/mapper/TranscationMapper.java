package com.yunn.autumnnacos.mapper;

import com.yunn.autumnnacos.model.GroupDo;
import com.yunn.autumnnacos.model.TranscationLearnDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yunN
 * @date 2022/07/13
 */
@Repository
public interface TranscationMapper extends JpaRepository<TranscationLearnDo, Integer> {

    @Query(value = "select new com.yunn.autumnnacos.model.Group(t.name ,sum(t.amount) ) from TranscationLearnDo t group by t.name")
    List<GroupDo> queryByGroup();

}
