package com.yunn.interview;

/**
 * AboutClassLoader
 *
 * @author yunN
 * @createTime 2021年03月01日 19:44
 * @description
 */
public class AboutClassLoader {


    /**
     * ClassLoader() 仅仅将class文件加载进入jvm，不会执行static代码块，也就不会初始化这个类，除非执行类newInstance()
     *
     * Class.forName() 会初始化这个类，也就是会执行static代码块。
     *
     *
     * @param args /
     * @throws Exception /
     */
    public static void main(String[] args) throws Exception {
        // Name name = (Name) Name.class.getClassLoader().loadClass("com.yun.view.Name").newInstance();
        Name name = (Name) Class.forName("com.yunn.interview.Name").newInstance();
    }
}

class Name {
    static {
        System.out.println("Name be loaded to jvm...");
    }
}
