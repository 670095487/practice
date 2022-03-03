package com.example.dockerdemo.mapper;

import com.example.dockerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @author yunN
 * @date 2021/10/27
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update T_USER SET " +
            "name = case when :#{#user.name} is null then name else :#{#user.name} end," +
            "address =:#{#user.address}, age =:#{#user.age} where id =:#{#user.id}")
    void updateUser(@Param("user") User user);

    @Query(nativeQuery = true, value = "select * from T_USER WHERE ID = ?1")
    User findById(@Param("id") int id);

    @Query(nativeQuery = true, value = "select * from T_USER where address = ?1")
    User findByAddress(String addr);

    User findByIdAndName(int id, String name);
}
