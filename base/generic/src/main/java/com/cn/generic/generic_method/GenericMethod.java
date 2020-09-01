package com.cn.generic.generic_method;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 2020/8/27 19:56
 * @since 1.0.0
 */
@Data
public class GenericMethod<T> {
    T t;

    public GenericMethod(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod(1);
        genericMethod.showName_1(new Fruit());
        Object o = genericMethod.showName_2(new Orange(), new Fruit());
        System.out.println("返回参数v: " + o.getClass());
        genericMethod.showName_3(new Fruit(), new Orange(), new Apple());
        GenericMethod.getName(new Fruit());

        /**
         * 泛型数组
         * 不能创建一个确切的泛型类型的数组 即创建数组不允许指定参数类型
         * 数组的类型不可以是类型变量，除非是采用通配符的方式，因为对于通配符的方式，最后取出数据是要做显式的类型转换的
         */
        GenericMethod<Integer>[] arrs = new GenericMethod[2];
        GenericMethod<?>[] arrss = new GenericMethod<?>[2];
        //这样是不被允许的
//        GenericMethod<Integer>[] arrsss = new GenericMethod<Integer>[2];
        arrs[0] = genericMethod;
        System.out.println("泛型数组: " + arrs[0]);

    }

    /**
     * 1、public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2、只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3、<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4、与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     * 5、泛型方法和泛型类或者泛型接口中的字符串没有必然关系
     * @param t
     * @param <T>
     */
    public <T> void showName_1(T t) {
        System.out.println("showName_1 : " + t.toString());
    }

    //指定多个泛型 包括返回参数
    public <T, V> V showName_2(T t,V v) {
        System.out.println("showName_2 : " + t.toString());
        V result = (V) t.toString();
        return result;
    }
    //多个泛型参数的指定
    public <E> void showName_3(E... e) {
        Arrays.stream(e).forEach(temp -> System.out.println("showName_3 : " + temp));

    }

    /**
     * 静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
     * 如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String getName(T t) {
        System.out.println("getName : " + t.toString());
        return t.toString();
    }

    public static class Fruit{
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

    static class Apple{
        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }
    }
}
