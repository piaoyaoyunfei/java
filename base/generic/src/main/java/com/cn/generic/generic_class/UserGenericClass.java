package com.cn.generic.generic_class;

/**
 * @author admin
 * @version 2020/8/27 14:55
 * @since 1.0.0
 * @description 泛型类
 * 特点:
 * 泛型实在编译阶段生效的 在运行阶段已经确认了类型参数
 * 泛型实际上是声明一种类型格式 供需要此类的所有类型去使用 比如 GenericClass 泛型类中对传入的类型参数进行输出
 * 通过泛型可以完成对一组类的操作对外开放相同的接口。最典型的就是各种容器类，如：List、Set、Map
 * 泛型的类型参数必须是对象
 * 泛型类的两种使用方式:
 * 1、不指定泛型类型
 * 2、指定泛型类型 这种情况下 类型参数已经确定
 */
public class UserGenericClass{

    /**
     * 泛型通配符的使用
     *
     * 同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的
     *
     * 类型通配符一般是使用？代替具体的类型实参 可以理解为时 Object
     * 此处’？’是类型实参，而不是类型形参
     * 再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型
     * @param object
     * @return
     */
    private static Object getGeneric(GenericClass<?> object) {
        return object.getT();
    }

    public static void main(String[] args) {
        //不指定泛型类的类型
        System.out.println("不指定泛型类的类型");
        GenericClass genericClass = new GenericClass();
        genericClass.handle(123);
        System.out.println("genericClass 实例化对象信息 " + genericClass);
        System.out.println("genericClass 对象本身的类型 " + genericClass.getClass());
        System.out.println("genericClass 类型参数的值 " + genericClass.getT());
        System.out.println("genericClass 类型参数的类型 " + genericClass.getT().getClass());

        //指定泛型类的类型
        System.out.println("指定泛型类的类型");
        GenericClass<String> genericString = new GenericClass<>();
        genericString.handle("abc");
        System.out.println("genericString 实例化对象信息 " + genericString);
        System.out.println("genericString 对象本身的类型 " + genericString.getClass());
        System.out.println("genericString 类型参数的值 " + genericClass.getT());
        System.out.println("genericString 类型参数的类型 " + genericString.getT().getClass());
        System.out.println(getGeneric(genericString));

        //泛型通配符使用
        System.out.println("泛型通配符使用");
        GenericClass<Integer> genericClassInteger = new GenericClass<>();
        genericClassInteger.handle(1);
        System.out.println(getGeneric(genericClassInteger));

        GenericClass<Number> genericClassNumber = new GenericClass<>();
        genericClassNumber.handle(2);
        System.out.println(getGeneric(genericClassNumber));
    }

}
