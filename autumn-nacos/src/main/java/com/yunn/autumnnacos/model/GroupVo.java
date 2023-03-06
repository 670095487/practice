package com.yunn.autumnnacos.model;

import com.yunn.autumnnacos.model.base.OutputConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yunN
 * @date 2022/11/09.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupVo implements OutputConverter<GroupVo, GroupDo> {

    public String name;

    public long x;
}
