package com.yunn.autumn.mysql;

/**
 * Notes
 *
 * @author: yunN
 * @createTime: 2020年10月26日 09:00
 * @description: 数据库学习笔记
 */
public class MysqlNotes {


    /**
     * 1.根据账号取hash，拿到对应表的下标，
     * 2.根据拿到的下标，组合成对应的表名，
     * 3.执行对应的sql
     *
     * @param args
     */
    public static void main(String[] args) {
        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        String key = "670095487";
        int h = key.hashCode();
        int i = h ^ (h >>> 8);
        int result = i % 8;
        System.out.println(Math.abs(result));
    }
}
