package com.cn.generic.generic_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

/**
 * @author admin
 * @version 2020/8/28 17:17
 * @since 1.0.0
 * @description 泛型数组的说明
 * 在Java中，我们不能实例化（注意我说的是实例化）一个参数化类型的数组，但是却可以参数化数组本身的类型
 * 简单解释一下 java中我们是可以把数组的元素设置为一个泛型 即参数化数组本身的类型
 *  但是我们不可以实例化也就是new一个数组 数组的元素是包含泛型类型的对象 即 list<T>[]
 */
public class GenericArray {

    public static void main(String[] args) {
//        instanceArray();

//        instanceGenericArray(new ArrayList<String>(), new ArrayList<String>());
//        instanceGenericArray(1, 2, 3);

        Integer[] integers = instanceGenericArray(2, Integer.class);
    }

    /**
     * 数组元素通过泛型参数进行指定 是可以正常输出和写入数组的
     * 这是因为在运行数组创建的时候本身的泛型类型已经确定了
     * @param t
     * @param <T>
     */
    public static <T> void instanceGenericArray(T... t) {
        T[] arr = t;
        System.out.println("数组元素参数化类型: " + t.getClass());
        Arrays.stream(arr).forEach(temp -> System.out.println("数组元素参数化结果: " + temp));
    }

    /**
     * 该方法也是将数组元素参数化了 但是T[] arr = new T[size]时编译错误 是因为在进行数组创建的时候没有确定数组的参数类型
     * 当然 可以通过新建一个 new Object[size] 来进行数组的创建 但是在指定泛型类型时还是需要强制转换 同样会出现 java.lang.ClassCastException
     *  所以 在创建泛型数组时参数化的数组元素需要在创建时明确参数的类型
     * @param size
     * @param <T>
     */
    public static <T> T[] instanceGenericArray(int size, Class<T> tClass) {

        //编译失败
//        T[] arr = new T[size];
        T[] arr = (T[]) new Object[size];
        System.out.println("数组元素参数化类型: " + T.getClass());
        Arrays.stream(arr).forEach(temp -> System.out.println("数组元素参数化结果: " + temp));
        return arr;
    }


    public static void instanceArray() {
        /**
         * 我们用list为例说明泛型数组
         * new List<T>[10]
         * ArrayList<>()[10]
         * new ArrayList<String>()[10]
         * 上述三种实例化方式都会出现编译错误，因为数组需要明确的元素类型 但是list集合是一个泛型类
         * <span>在jvm中有一个擦除机制 即泛型类型会在运行阶段去除掉 虚拟机并不知道list是何种类型 即使声明了 new ArrayList<String> </span>
         *
         * new List<?>[10]
         * new List[10]
         * 使用通配符或者不声明泛型参数 是可以进行实例化并进行相关操作的
         */
//        List[] list = new List<T>[10];
//        List[] list = new ArrayList<>()[10];
//        List[] list = new ArrayList<String>()[10];

//        List[] list = new List<?>[10];
        List<String>[] list = new List[10];

        list[0] = new ArrayList<>();
        list[1] = new ArrayList<>(1);

        Arrays.stream(list).parallel().forEach(temp -> System.out.println("数组元素输出: " + temp));

        /**
         * 通过声明一个object数组会在强制转换时发生 ClassCastException
         *
         */
        List<Integer>[] array;
        Object[] objects = new Object[10];
        array = (List<Integer>[]) objects;

        array[0] = new ArrayList<>(1);
        array[1] = new ArrayList<>(1);

        Arrays.stream(array).parallel().forEach(temp -> System.out.println("另外数组元素输出: " + temp));

    }
}
