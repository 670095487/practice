package com.yunn.autumn.netty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunN
 * @date 2022/06/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForTestSerializer {
    private byte[] content;
    private int len;
}
