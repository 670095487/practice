package com.yunn.autumn.thread.th05;

import com.yunn.autumn.sourcecode.hashmap.MyMap;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * NuccpayCodeTest
 *
 * @Author: Bff
 * @CreateTime: 2020-05-06
 * @Description:
 */
@SuppressWarnings("all")
public class NuccPayCodeTest<T> {
    String nuccpaycode = null;

    @Test
    public void test() {
        System.out.println(m1(nuccpaycode));
    }

    public String m1(String nuccpaycode) {
        if (nuccpaycode != null) return nuccpaycode;

        // m2(nuccpaycode);
        return m2(nuccpaycode);
    }

    public String m2(String nuccpaycode) {
        nuccpaycode = "测试赋值";
        return nuccpaycode;
    }


    private void doRealLogic(MyMap<String, Object> myMap, String key, Class c) throws NoSuchMethodException {
        Object o = myMap.get(key);
        String name = c.getConstructor().getName();
        if (name.equals("httpUrl")) {
            //实例化httpUrl
        } else if (name.equals("http")) {
            //实例化
            System.out.println("以后在家里写代码 岂不是只能这么写了。。" +
                    "越过寒鸦");
        }

    }


    @Test
    public void hhMMss() {
        System.out.println(new SimpleDateFormat("HHMMSS").format(new Date()));
    }


}
