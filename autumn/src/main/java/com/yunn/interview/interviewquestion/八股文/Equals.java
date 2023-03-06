package com.yunn.interview.interviewquestion.八股文;

import java.util.Objects;

/**
 * @author yunN
 * @date 2023/02/18.
 */
public class Equals {

    public static void main(String[] args) {
        DemoForEquals d1 = new DemoForEquals("123", "456");
        DemoForEquals d2 = new DemoForEquals("123", "456");
        System.out.println(d2.equals(d1));
        System.out.println(d1.hashCode() == d2.hashCode());
    }
}

class DemoForEquals{
   private String name;
   private String address;

    public DemoForEquals(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public DemoForEquals() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoForEquals that = (DemoForEquals) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
