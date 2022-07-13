package com.yunn.autumnnacos.mapper;

import com.yunn.autumnnacos.model.TranscationLearnDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yunN
 * @date 2022/07/13
 */
@Repository
public interface TranscationMapper extends JpaRepository<TranscationLearnDo, Integer> {

}
