package com.yiqing;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {

    private class Node {
        Node next;
        Item item;
    }

    private Node first;
    private Node last;
    private int N;

    public Steque(){};

    public Steque(Steque<Item> q){
        Steque<Item> r = new Steque<Item>();
        int size = q.size();
        for(int i = 0; i < size; i ++) {
            Item item = q.pop();
            q.enqueue(item);
            r.enqueue(item);
        }
        this.first = r.first;
        this.last = r.last;
        this.N = r.size();
    }

    public void push(Item item) {//队列头
        Node node = new Node();
        node.item = item;
        if (this.isEmpty()) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        N++;
    }

    public Item pop() {
        if (this.isEmpty()) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (this.isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        N++;
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }
    public Steque<Item> catenation(Steque<Item> q2){
        Steque<Item> temp = new Steque<Item>(q2);
        //Queue<Item> q1copy = new Queue<Item>(q);
        while (temp.size()!=0){
            this.enqueue(temp.pop());
        }
        return this;
    }

    public Iterator<Item> iterator(){
        return new StequeIterator();
    }

    private class StequeIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public void remove(){}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    public static void main(String[] args){
        Steque<String> StequeString1 = new Steque<String>();
        StequeString1.enqueue("2我的");
        StequeString1.enqueue("2名字");
        StequeString1.enqueue(  "2叫");
        StequeString1.enqueue("2小白的");
        StequeString1.enqueue("2一清");

//        for(String i : StequeString1){
//            System.out.println(i);
//        }

        Steque<String> StequeString2 = new Steque<String>();
        StequeString2.push("我的");
        StequeString2.push("名字");
        StequeString2.push("叫");
        StequeString2.push("小白的");
        StequeString2.push("一清");

//        for(String i : StequeString2){
//            System.out.println(i);
//        }

        Steque<String> StequeString3 = new Steque<String>(StequeString1);
        StequeString3.catenation(StequeString2);
        for(String i : StequeString3){
            System.out.println(i);
        }
    }
}
