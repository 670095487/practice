package com.yunn.autumn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yunN
 * @date 2022/10/04
 */
public class Trie {

    private final Map<String, Integer> dict;

    public Trie() {
        this.dict = new HashMap<>();
    }

    public void insert(String word) {
        dict.put(word, 1);
    }

    public boolean search(String word) {
        return dict.get(word) == null;
    }

    public boolean startsWith(String prefix) {
        return dict.keySet().stream().anyMatch(k -> k.startsWith(prefix));
    }
}

class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
