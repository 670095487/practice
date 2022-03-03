package com.yunn.autumn.compare.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunN
 * @date 2021/11/05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileModelVo {

    private String changeType;

    private FileModel fileModel;


}
