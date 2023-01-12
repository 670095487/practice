package com.yunn.workquestion;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author yunN
 * @date 2022/04/03.
 */
public class HandStrLenGt40 {

    private static final int LONGEST = 4;

    private HandStrLenGt40UseObj getResult(@NotNull HandStrLenGt40UseObj obj) {
        int first = handleGt40(obj, "123 25", 0);
        handleGt40(obj, "456 2", first);
        return obj;
    }

    private int handleGt40(HandStrLenGt40UseObj obj, String targetStr, int position) {
        if (StringUtils.isBlank(targetStr)) {
            return position + 1;
        }
        String currentWord = targetStr.split("\\s+")[0];
        Auxiliary auxiliary = fillingObj1(obj, currentWord, Auxiliary.builder().position(position).isCurrentCompleted(true).build());
        // 符合条件说明本次还没有处理完成
        if (auxiliary.getPosition() == position || !auxiliary.isCurrentCompleted) {
            if (currentWord.length() < targetStr.length()) {
                targetStr = targetStr.substring((currentWord.length() + 1));
                // 等于则说明已经处理过了这一次的最后一个单词，这时候应该结束这一次的递归
            } else {
                targetStr = StringUtils.EMPTY;
            }
        }
        return handleGt40(obj, targetStr, auxiliary.getPosition());
    }


    private Auxiliary fillingObj1(HandStrLenGt40UseObj obj, String word, Auxiliary auxiliary) {
        int wordLength = word.length();
        switch (auxiliary.getPosition()) {
            case 0:
                String name1 = obj.getName1();
                if (wordLength > LONGEST) {
                    handleSingleWordGt40(obj, word, auxiliary, "name1");
                    break;
                }
                if (StringUtils.isBlank(name1)) {
                    obj.setName1(word);
                } else if (name1.length() + word.length() <= LONGEST - 1) {
                    obj.setName1(name1 + StringUtils.SPACE + word);
                } else {
                    auxiliary.setPosition(++auxiliary.position);
                }
                break;
            case 1:
                String name2 = obj.getName2();
                if (wordLength > LONGEST) {
                    handleSingleWordGt40(obj, word, auxiliary, "name2");
                    break;
                }
                if (StringUtils.isBlank(name2)) {
                    obj.setName2(word);
                } else if (name2.length() + word.length() <= LONGEST - 1) {
                    obj.setName2(name2 + StringUtils.SPACE + word);
                } else {
                    auxiliary.setPosition(++auxiliary.position);
                }
                break;
            default:
                String name3 = obj.getName3();
                if (StringUtils.isBlank(name3)) {
                    obj.setName3(word);
                } else if (name3.length() + word.length() <= LONGEST - 1) {
                    obj.setName3(name3 + StringUtils.SPACE + word);
                } else {
                    obj.setName3(name3 + StringUtils.SPACE + word);
                    obj.setNeedWarning(true);
                }
        }
        return auxiliary;
    }


    private static final LinkedList<Field> filedList = getFieldsInObj();

    private static LinkedList<Field> getFieldsInObj() {
        Field name1 = null;
        Field name2 = null;
        Field name3 = null;
        try {
            name1 = HandStrLenGt40UseObj.class.getDeclaredField("name1");
            name2 = HandStrLenGt40UseObj.class.getDeclaredField("name2");
            name3 = HandStrLenGt40UseObj.class.getDeclaredField("name3");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return new LinkedList<>(Arrays.asList(name1, name2, name3));
    }


    // 1. 拿到本次需要操作的属性名，
    // 2. 反射取值，
    // 3. 根据linkList找到下一个待操作的元素
    private void handleSingleWordGt40(HandStrLenGt40UseObj obj, String word, Auxiliary auxiliary, String currentFieldName) {
        String alreadyFilledValue = StringUtils.EMPTY;
        Field field = null;
        try {
            field = obj.getClass().getDeclaredField(currentFieldName);
            field.setAccessible(true);
            alreadyFilledValue = (String) field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isBlank(alreadyFilledValue)) {
            try {
                assert field != null;
                field.set(obj, word.substring(0, LONGEST));
                Field next = filedList.get(filedList.indexOf(field) + 1);
                next.setAccessible(true);
                next.set(obj, word.substring(LONGEST));
            } catch (Exception exception) {
                //
            }
        } else {
            int availableLength = LONGEST - alreadyFilledValue.length();
            try {
                assert field != null;
                field.set(obj, alreadyFilledValue + StringUtils.SPACE + word.substring(0, availableLength));
                Field next = filedList.get(filedList.indexOf(field) + 1);
                next.setAccessible(true);
                next.set(obj, word.substring(availableLength + 1));
            } catch (IllegalAccessException e) {
                //
            }
        }
        auxiliary.setCurrentCompleted(false);
        auxiliary.setPosition(++auxiliary.position);
        obj.setNeedWarning(true);
    }

    private int fillingObj(HandStrLenGt40UseObj obj, LinkedList<String> list, int position) {

        if (list.isEmpty()) {
            return position;
        }

        String word = list.peek();
        switch (position) {
            case 0:
                if (obj.getName1().length() + word.length() <= LONGEST) {
                    obj.setName1(obj.getName1() + word);
                    list.pop();
                } else {
                    position++;
                }
                fillingObj(obj, list, position);
                break;
            case 1:
                if (obj.getName2().length() + word.length() <= LONGEST) {
                    obj.setName2(word);
                    list.pop();
                } else {
                    position++;
                }
                fillingObj(obj, list, position);
                break;
            case 2:
                if (obj.getName3().length() + word.length() <= LONGEST) {
                    obj.setName3(word);
                    ++position;
                    list.pop();
                } else {
                    obj.setName3(word);
                    obj.setNeedWarning(true);
                    list.pop();
                    ++position;
                }
                fillingObj(obj, list, position);
            default:
                return Integer.MAX_VALUE;
        }
        return position;
    }

    @Test
    public void test() {
        System.out.println(getResult(HandStrLenGt40UseObj.builder().build()));
    }
}

@Data
@Builder
class HandStrLenGt40UseObj {
    private String name1;
    private String name2;
    private String name3;
    boolean needWarning;
}

@Data
@Builder
class Auxiliary {
    int position;
    boolean isCurrentCompleted;
}
// name1 ="1234 567 89" ;
// name2 = ;
// name3 = ;

// name1 = "1234"
// name2 = "567"
// name3 = "89"

// name1 = "12"
// name2 = "12345"
// name3 =

// name1 = "12"
// name2 = "1234"
// name3 = "5"
// needWarning = true;

// name1= "1234 5678"
// name2= "1234 5678"
// name3= "1234 5678"

// name1= "1234"
// name2= "5678"
// name3= "1234 5678 1234 5678"
// needWarning = true;

// 1:"123 56 78"
// 2:"45 63"
// name1 = "123 56"
// name2 = "78"
// name4 = ""
// name5 = ""

// name1 = ""
