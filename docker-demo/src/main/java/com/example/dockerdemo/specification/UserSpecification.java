package com.example.dockerdemo.specification;

import com.example.dockerdemo.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author yunN
 * @date 2021/12/08.
 */
public class UserSpecification {

    public static Specification<User> customerAddress() {
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("address"), "闵行");
            }
        };
    }
}
