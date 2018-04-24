package com.example.zhangzhongshuai.mytest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhongshuai on 2017/7/31.
 */

public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> llist() {
        return new LinkedList<T>();
    }

    public static <T> List<T> makeList(T... args) {
        ArrayList<T> al = new ArrayList<T>();
        for (T t : args) {
            al.add(t);
        }
        return al;
    }
}
