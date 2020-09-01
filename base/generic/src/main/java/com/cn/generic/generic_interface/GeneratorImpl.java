package com.cn.generic.generic_interface;

import java.util.Random;

/**
 * @author admin
 * @version 2020/8/27 16:34
 * @since 1.0.0
 */
public class GeneratorImpl extends GeneratorAbstract<String> {

    public GeneratorImpl(String s) {
        super(s);
    }

    @Override
    public String next() {
        return String.valueOf(new Random().nextInt());
    }

    public static void main(String[] args) {
        GeneratorImpl generator = new GeneratorImpl("abc");
        System.out.println(generator.next());
        System.out.println(generator.getT().getClass());
    }
}
