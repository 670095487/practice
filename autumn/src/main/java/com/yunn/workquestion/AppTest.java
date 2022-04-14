package com.yunn.workquestion;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */

    private static final int LONGEST = 6;

    public void testApp() {
        HandStrLenGt40UseObj obj = new HandStrLenGt40UseObj("", "", "", false);
        HandStrLenGt40UseObj result = getResult(obj);
        System.out.println(result);
    }

    private HandStrLenGt40UseObj getResult(@NotNull HandStrLenGt40UseObj obj) {
        int point = 1;//point指针，指向你下一次处理字符串的时候从哪开始
        point = handleGt40(obj, "1234 56", point);
        point = handleGt40(obj, "14", point);
        System.out.println(point);
        return obj;
    }

    private int handleGt40(HandStrLenGt40UseObj obj, String targetStr, int point) {

        if (StringUtils.isEmpty(targetStr)) {
            //每真正完成一次字符串的处理+1次，这样不管前面有没有装满，都从下一个节点开始处理
            return point + 1;
        }
        //每次递归实际只处理一个单词
        String word = targetStr.split(" ")[0];
        targetStr = fillingObjNew(obj, word, point, targetStr);
        System.out.println(targetStr);
        //递归执行的handleGt40内point不变
        return handleGt40(obj, targetStr, point);
    }

    private String fillingObjNew(HandStrLenGt40UseObj obj, String word, int point, String targetStr) {
        //如果point>2,说明本次obj两个个属性值已定，全部放到最后一个值中去
        if (point > 2) {
            obj.setName3(obj.getName3() + " " + targetStr);
            //如果最后一个字段长度超过40也设置为true
            if (obj.getName3().length() > LONGEST && !obj.isNeedWarning()) {
                obj.setNeedWarning(Boolean.TRUE);
            }
            return StringUtils.EMPTY;
        }
        //如果进来的单词长度超过了40，说明有问题
        if (word.length() > LONGEST && !obj.isNeedWarning()) {
            obj.setNeedWarning(Boolean.TRUE);
        }
        //从指针point开始处理
        if (point == 1) {
            if ((obj.getName1() + " " + word).length() <= LONGEST) {
                if (StringUtils.isBlank(obj.getName1())) {
                    obj.setName1(word);
                } else {
                    obj.setName1(obj.getName1() + " " + word);
                }
            } else {
                if ((obj.getName2() + " " + word).length() <= LONGEST) {
                    if (StringUtils.isBlank(obj.getName2())) {
                        obj.setName2(word);
                    } else {
                        obj.setName2(obj.getName2() + " " + word);
                    }
                    point = 2;
                } else {
                    obj.setName3(obj.getName3() + " " + word);
                    //如果最后一个字段长度超过40也设置为true
                    if (obj.getName3().length() > LONGEST && !obj.isNeedWarning()) {
                        obj.setNeedWarning(Boolean.TRUE);
                    }
                    point = 3;
                }
            }
        } else if (2 == point) {
            if ((obj.getName2() + " " + word).length() <= LONGEST) {
                if (StringUtils.isBlank(obj.getName2())) {
                    obj.setName2(word);
                } else {
                    obj.setName2(obj.getName2() + " " + word);
                }
            } else {
                obj.setName3(obj.getName3() + " " + word);
                //如果最后一个字段长度超过40也设置为true
                if (obj.getName3().length() > LONGEST && !obj.isNeedWarning()) {
                    obj.setNeedWarning(Boolean.TRUE);
                }
                point = 3;
            }
        }
        if (targetStr.length() <= word.length()) {
            return StringUtils.EMPTY;
        }
        return targetStr.substring(word.length() + 1);
    }
}

class FillingObjRst {
    private int point;//指针
    private String targetStr;//待处理的字符串

    public FillingObjRst(int point, String targetStr) {
        this.point = point;
        this.targetStr = targetStr;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTargetStr() {
        return targetStr;
    }

    public void setTargetStr(String targetStr) {
        this.targetStr = targetStr;
    }

    @Override
    public String toString() {
        return "{\"FillingObjRst\":{" + "\"point\":" +
                point +
                ",\"targetStr\":\"" +
                targetStr + '\"' +
                '}' +
                '}';
    }
}
