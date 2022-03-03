package com.yunn.autumn.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yunN
 * @date 2021/09/09.
 */
public class IteratorLearn {

    public Iterable<String> getIteratorResults() {

        int _weed = 100;

        ArrayList<String> res = new ArrayList<>();
        res.add("z");
        res.add("z1");
        res.add("c");

        return res;
    }

    public List<String> getIteratorResultsUseList() {

        ArrayList<String> res = new ArrayList<>();
        res.add("z");
        res.add("z1");
        res.add("c");

        return res;
    }

    @Test
    public void IteratorTest() {
        System.out.println(getIteratorResults());
    }


}
