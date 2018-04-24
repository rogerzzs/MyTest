package com.example.zhangzhongshuai.pattern;

/**
 * Created by zhangzhongshuai on 2018/4/20.
 */

public interface Selector {
    boolean end();

    Object current();

    void next();
}
