package com.yunn.interview.interviewquestion.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yunN
 * @date 2023/01/16.
 */
public class Trie {

    Set<String> set;

    public Trie() {
        this.set = new HashSet<>();
    }

    public void insert(String word) {
        set.add(word);
    }

    public boolean search(String word) {
        return set.contains(word);
    }

    public boolean startsWith(String prefix) {
        for (String s : set) {
            if (s.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
