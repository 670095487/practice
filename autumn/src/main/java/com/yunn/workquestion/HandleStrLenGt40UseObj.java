package com.yunn.workquestion;

/**
 * @author yunN
 * @date 2022/04/10
 */
public class HandleStrLenGt40UseObj {
    private String name1;
    private String name2;
    private String name3;
    private boolean needWarning;

    public HandleStrLenGt40UseObj(String name1, String name2, String name3, boolean needWarning) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.needWarning = needWarning;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public boolean isNeedWarning() {
        return needWarning;
    }

    public void setNeedWarning(boolean needWarning) {
        this.needWarning = needWarning;
    }

    @Override
    public String toString() {
        final StringBuilder JSON = new StringBuilder("{\"HandStrLenGt40UseObj\":{");
        JSON.append("\"name1\":\"")
                .append(name1).append('\"');
        JSON.append(",\"name2\":\"")
                .append(name2).append('\"');
        JSON.append(",\"name3\":\"")
                .append(name3).append('\"');
        JSON.append(",\"needWarning\":")
                .append(needWarning);
        JSON.append('}');
        JSON.append('}');
        return JSON.toString();
    }
}
