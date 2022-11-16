// package com.yunn.autumn.thread.threadenhance3.atomic;
//
// import sun.misc.Unsafe;
//
// import java.lang.reflect.Field;
// import java.lang.reflect.Modifier;
// import java.util.HashSet;
//
// /**
//  * UseUnsafeTest
//  *
//  * @author: yunN
//  * @createTime: 2021/01/29 19:17:24
//  * @description: 使用unsafe做一些打破规则的事情
//  */
// public class UseUnsafeTest {
//
//
//     /**
//      * 通过反射拿到 unsafe
//      *
//      * @return /
//      */
//     private static Unsafe getUnsafe() {
//         try {
//             Field field = Unsafe.class.getDeclaredField("theUnsafe");
//             field.setAccessible(true);
//             return (Unsafe) field.get(null);
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
//
//     /**
//      * 计算对象属性所占的字节长度?
//      * @param o ?
//      * @return ?
//      */
//     private static long sizeof(Object o) {
//         Unsafe unsafe = getUnsafe();
//         HashSet<Field> fields = new HashSet<>();
//         Class c = o.getClass();
//         while (c != Object.class) {
//             //getDeclaredFields():获取类声明的所有字段，不包含父类中声明的
//             //getFields:获取类声明的所有公共字段，包括父类中声明的
//             Field[] declaredFields = c.getDeclaredFields();
//             for (Field f : declaredFields) {
//                 //getModifiers()获取字段前面的修饰符
//                 //静态字段不要
//                 if ((f.getModifiers() & Modifier.STATIC) == 0) {
//                     fields.add(f);
//                 }
//             }
//             //获取其父类
//             c = c.getSuperclass();
//         }
//
//         long maxOffset = 0;
//         for (Field field : fields) {
//             long offset = unsafe.objectFieldOffset(field);
//             if (offset > maxOffset) {
//                 maxOffset = offset;
//             }
//         }
//         return ((maxOffset / 8) + 1) * 8;
//     }
// }
