package com.lazyboy.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: zhouwei
 * @date: 2020/5/14 12:08
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");
        map.put("D", "c");
        map.put("E", "c");
        map.put("F", "c");
        map.put("G", "c");
        map.put("H", "c");
        map.put("J", "c");
        map.put("K", "c");
        System.out.println("map = " + map);

    }

}