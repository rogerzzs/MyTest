package com.example.zhangzhongshuai.pattern;

/**
 * Created by zhangzhongshuai on 2018/4/20,houhouhouo
 */

public class Seqence {
    private Object[] items;
    private int next = 0;
    private int x = 0;

    public Seqence(int size) {

        items = new Object[size];
    }

    public void add(Object o) {
        if (next < items.length) {
            items[next++] = o;
        }
    }

    class SelectorImpl implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public Selector getSelectorImpl() {
        return new SelectorImpl();
    }
}
