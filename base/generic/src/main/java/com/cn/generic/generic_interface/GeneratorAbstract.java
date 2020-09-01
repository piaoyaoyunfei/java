package com.cn.generic.generic_interface;

import lombok.Data;

/**
 * @author admin
 * @version 2020/8/27 16:29
 * @since 1.0.0
 * @description 未指定泛型的类型时无法进行相关操作 只能在抽象方法中实现公共的逻辑不能涉及形参的相关操作
 */
@Data
public abstract class GeneratorAbstract<T> implements Generator<T> {
    T t;

    public GeneratorAbstract(T t) {
        this.t = t;
    }
}
