package com.example.zhangzhongshuai.pattern;

/**
 * Created by zhangzhongshuai on 2018/4/20.
 */

public class Outer {
    private int x;

    class Iner {

    }

    public Iner getIner() {
        return new Iner();
    }
}
