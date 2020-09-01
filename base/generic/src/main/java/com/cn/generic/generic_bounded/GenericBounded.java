package com.cn.generic.generic_bounded;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 2020/8/28 13:46
 * @since 1.0.0
 * @description 泛型的边界问题我们主要是以list集合的泛型来进行说明
 * 泛型的边界主要是为了给一个泛型指定一个范围，方便输入或者输入
 */
public class GenericBounded {

    public static void main(String[] args) {
        unbounded(new Fruit());
        superBounded();
        extendsBounded();
    }

    /**
     * 无边界使用
     * 总结:
     * 输入输出不限制，输入可变所以无法进行有效的输入，输出没有限制
     */
    public static <T> void unbounded(T t) {
        List<?> list = new ArrayList<>();
        /**
         * 无边界泛型参数无法输入任何对象
         * 虽然我们可以将通配符看作是object，但是在插入list是并不知道是 String 还是 Integer 还是其他对象类型
         * 所以通配符使用的无边界泛型类型无法接收任何对象类型，除过 null.
         */
//        list.add(t);
//        list.add("a");
//        list.add(1);
        //因为任何对象都可能为 null
        list.add(null);

        /**
         * 无边界泛型参数的输出值可以为任何对象，因为通配符的泛型类型可理解为 object 那么获取 object 没有任何问题
         */
        Object o = list.get(0);
        System.out.println("无边际输出: "+(Integer) o);
    }

    /**
     * 下边界泛型使用
     * 总结:
     * 输入限制了必须是指定类型的子类或者本身 因为泛型规定的类型特性在子类中肯定是有的
     * 输出没有限制 父类没有上线 object
     */
    public static void superBounded() {

        List<? super Fruit> list = new ArrayList<>();
        /**
         * 下边界泛型 可以理解为规定了泛型类型的最大特性 超过此对象无法进行输入
         * 假如可以对指定的泛型类型的父类进行输入，那么指定类型的本身特性在父类中并没有，这样会造成运行时异常，所以编译不过
         * 总之 可以将下边界理解为泛型拥有的最大特性，只要含有该特性的类型都可以进行输入
         * <span>java子类中包含了父类的特性 但是 父类不一定包含子类的特性</span>
         */
//        list.add(new Person());
        list.add(new Fruit());
        list.add(new Apple());
        list.add(new Orange());
        /**
         * 下边界泛型输出 可以是任何类型，因为下边界指定的是泛型类型的父类，所有父类都可以看作是 object
         */
        Object object = list.get(0);
        System.out.println("获取下边界: " + object.toString());
        list.parallelStream().forEach(fruit -> System.out.println("下边界输出: " + fruit.toString()));
    }

    /**
     * 上边界泛型使用
     * 总结:
     * 输入仅仅指定了最少的类型特性，所以输入对象可变，无法进行有效输入
     * 输出限制了泛型类型，因为所有的对象都继承了泛型类型，所有输出都是泛型类型
     */
    public static void extendsBounded() {
        List<? extends Fruit> list = new ArrayList<>();

        /**
         * 上边界泛型 实际上是指定了输入对象最大的值 但是并没有规定最小值 也就说没有规定输入的对象最小值 那么所有继承该泛型类型的类型度可能
         * 对于java原来 不确定就意味着风险，所以上边界的输入只能是 null 其他的都不可以
         */
//        list.add(new Fruit());
//        list.add(new Apple());
//        list.add(new Orange());
        list.add(null);

        /**
         * 上边界的输出 因为已经制定了父类 所以输出的对象肯定都是父类的类型
         * 实际上 上边界就是为了规定输出类型的
         */
        Fruit fruit = list.get(0);
        System.out.println("上边界输出: " + fruit);

    }

    static class Person {

    }
    static class Fruit extends Person{
        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    static class Orange extends Fruit{
        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }

    static class Apple extends Fruit{
        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }
}
