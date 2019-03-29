package com.yiqing;

import java.util.Iterator;

public class learn_ArrayStack<Item> implements Iterable<Item> {
    private Item[]a = (Item[])new Object[1];
    private int N = 0;
    private boolean isEmpty(){return a == null;}
    private int size(){return N;}
    private void resize(int cap){
        Item[] temp = (Item[])new Object[cap];
        for(int i = 0;i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(Item item) {
        if (a.length == N) {
            resize(2 * N);
        }
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[N--];
        a[N] = null;
        if( N > 0 && N <= 1/4 * a.length){
            resize(1/2 * a.length);
        }
        return item;
    }
    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }
    private class ArrayIterator implements Iterator<Item> {
        private int i = N;
        public boolean hasNext(){return i > 0;}
        public Item next(){return a[i--];}
        public void remove(){}
    }
}
