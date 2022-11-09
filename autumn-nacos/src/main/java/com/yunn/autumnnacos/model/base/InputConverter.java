package com.yunn.autumnnacos.model.base;

import org.springframework.lang.Nullable;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/**
 * @author yunN
 * @date 2022/11/03.
 */
public interface InputConverter<D> {

    // default D convertTo() {
    //     // Get parameterized type
    //     ParameterizedType currentType = parameterizedType();
    //
    //     // Assert not equal
    //     Objects.requireNonNull(currentType,
    //             "Cannot fetch actual type because parameterized type is null");
    //
    //     Class<D> domainClass = (Class<D>) currentType.getActualTypeArguments()[0];
    //
    //     return BeanUtils.transformFrom(this, domainClass);
    // }
    //
    // @Nullable
    // default ParameterizedType parameterizedType() {
    //     return ReflectionUtils.getParameterizedType(InputConverter.class, this.getClass());
    // }
}
