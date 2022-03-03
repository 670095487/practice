package com.yunn.autumn.thread.threadenhance2.design.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * MyClassLoader
 *
 * @author yunN
 * @createTime 2021年01月24日 11:27
 * @description
 */
public class MyClassLoader extends ClassLoader {

    private final static String DEFAULT_DIR = "/Users/yunnuan/Desktop/files/classloader";

    private String dir = DEFAULT_DIR;

    private String classLoaderName;

    public MyClassLoader() {
        super();
    }

    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    /**
     * @param name package.package.xxx
     * @return /aaa/bbb/ccc/ddd.class
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //将包名格式转换为文件格式的
        String classPath = name.replace("\\.", "\\/");
        //读到文件的全限定名
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists())
            throw new ClassNotFoundException("class loaded failed..." + name);
        byte[] classBytes = loadClassBytes(classFile);

        if (null == classBytes || classBytes.length == 0)
            throw new ClassNotFoundException("class loaded failed..." + name);


        return this.defineClass(name, classBytes, 0, classBytes.length);
    }


    /**
     * 从一个文件中 读数据，并将数据转换到内存中
     *
     * @param classFile 文件全限定名
     * @return 二进制数组
     */
    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {
            byte[] buffer = new byte[1024];
            int len;
            //len = -1 说明已经读完了 : 从文件中读 <=1024byte 数据
            while ((len = fis.read(buffer)) != -1) {
                //将读出的数据写至内存中，一次写入buffer.length()大小的数据
                baos.write(buffer, 0, len);
            }
            baos.flush();
            //返回一个二进制数组
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
