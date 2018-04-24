package com.example.zhangzhongshuai.mytest;

/**
 * Created by zhangzhongshuai on 2017/7/28.
 */

public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public <X> void gnerricMethod(X x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        for (String s : "Phasers on stun!".split(" ")) {
            stack.push(s);
        }
        String ss;
        while ((ss = stack.pop()) != null) {
            System.out.println(ss);
        }
        stack.gnerricMethod("ss");
    }
}
