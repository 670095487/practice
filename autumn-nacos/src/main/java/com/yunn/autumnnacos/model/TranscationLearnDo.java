package com.yunn.autumnnacos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author yunN
 * @date 2022/07/13
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transcation_learn")// accountDo
public class TranscationLearnDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "amount")
    int amount;

}