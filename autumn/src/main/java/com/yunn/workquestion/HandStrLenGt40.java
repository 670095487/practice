package com.yunn.workquestion;

import lombok.Builder;
import lombok.Data;

/**
 * @author yunN
 * @date 2022/04/03.
 */
public class HandStrLenGt40 {

    public static void main(String[] args) {
        handStrLenGt40(HandStrLenGt40UseObj.builder()
                .name1("fulNameLastnameGoproCam iLoveThisCanYou doThisAnd iCantDoThis").build());
    }

    private final static String regex = "\\s+";

    // 每一个name(1~3)所存的字符串不能超过40，如果在40这个长度的单词前后出现了空格，那么需要保留单词的完整性
    // 如果第一个单词长度就超过了40个怎么办？
    // 如果按照规则切分，切分最后一次所得到的字符串长度超过了40怎么办？
    public static HandStrLenGt40UseObj handStrLenGt40(HandStrLenGt40UseObj hsLenGt) {
        String name1 = hsLenGt.getName1();
        if (name1.length() < 40) {
            return hsLenGt;
        }
        String[] name1sList = name1.split(regex, 3);
        return hsLenGt;

    }
}


@Data
@Builder
class HandStrLenGt40UseObj {
    String name1;
    String name2;
    String name3;
}
