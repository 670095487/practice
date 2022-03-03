package com.yunn.autumn.thread.threadenhance2.design.classLoader;

/**
 * BootClassLoader
 *
 * @author yunN
 * @createTime 2021年01月24日 10:37
 * @description
 */
public class BootClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));

        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());
    }
}


/*
*
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/resources.jar:
*
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/rt.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/sunrsasign.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jsse.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jce.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/charsets.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/lib/jfr.jar:
* /Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk/Contents/Home/jre/classes

 *
* */