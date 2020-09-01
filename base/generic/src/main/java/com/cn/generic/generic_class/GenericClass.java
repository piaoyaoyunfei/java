package com.cn.generic.generic_class;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author admin
 * @version 2020/8/27 14:54
 * 泛型类
 * @since 1.0.0
 */
@Getter
public class GenericClass<T> {

    T t;

    protected String handle(T t) {
        this.t = t;
        return t.getClass().getName();
    }

    public T getT() {

        return t;
    }
}
