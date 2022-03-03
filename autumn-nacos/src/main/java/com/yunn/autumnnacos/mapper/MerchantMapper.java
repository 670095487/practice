package com.yunn.autumnnacos.mapper;

import com.yunn.autumnnacos.model.MerchantDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MerchantMapper extends JpaRepository<MerchantDo, Long>, JpaSpecificationExecutor<MerchantDo> {

    @Select("select * from merchant;")
    List<MerchantDo> getMerchantDos();

}
