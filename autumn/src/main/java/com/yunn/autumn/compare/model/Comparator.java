package com.yunn.autumn.compare.model;

import java.util.List;

/**
 * @author yunN
 * @date 2021/11/05
 */
public interface Comparator<T, U> {

    String CHANGE_TYPE_NEW = "new";

    String CHANGE_TYPE_DELETE = "delete";

    String CHANGE_TYPE_UPDATE = "update";

    List<T> compare(List<T> previous, List<U> current);
}
