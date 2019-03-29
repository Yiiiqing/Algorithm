package com.yiqing;

public class LinkedListExecise3 {
    public static void main(String[] args){
        CircularLinkedListQueue<String> c = new CircularLinkedListQueue<String>();
        c.enqueue("我的");
        c.enqueue("名字");
        c.enqueue("叫");
        c.enqueue("小白的");
        c.enqueue("一清");
        c.dequeue();
        c.dequeue();
        c.enqueue("ddd");
        for(String i : c){
            System.out.println(i);
        }
    }
}
