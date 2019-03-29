package com.yiqing;

import java.util.Iterator;
import java.util.ListIterator;

public class ResizingArrayQueueOfStringsEX1_3_14<Item> implements Iterable<Item> {
    private Item[] a;
    int N;

    public ResizingArrayQueueOfStringsEX1_3_14(){
        a = (Item[]) new Object[1];
    }

    private void resize(int newcap){
        Item[] b = (Item[]) new Object[newcap];
        for(int i = 0; i < N ; i++){
            b[i] = a[i];
        }
        a = b;
    }
    public boolean isEmpty(){
        return (N == 0);
    }
    public int size(){
        return N;
    }
    public int cap(){
        return a.length;
    }
    public void enqueue(Item item) {
        if (N == a.length) {
            resize(2*a.length);
            System.out.println("recap!!!!!!");
        }
        a[N++] = item;
        //N++;
    }
    public Item dequeue(){
        if(N>0 && N == a.length/4) {
            resize(a.length/2);
            System.out.println("recap!!!!!!");
        }
        Item item = a[0];
        N--;
        for(int i = 1; i <= N; i++){
            //Item temp = a[i];
            a[i-1] = a[i];
        }
        return item;
    }
    public Iterator<Item> iterator(){
            return new Resizingiterator();
        }

    private class Resizingiterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext(){
            return i > 0;
        }
        public void remove(){}
        public Item next(){
            return a[1];
        }
    }
}
