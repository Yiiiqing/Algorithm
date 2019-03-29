package com.yiqing;

import java.util.Iterator;

public class GeneralizedQueue<Item> implements Iterable<Item>{
    private Item[] a;
    int N;

    public GeneralizedQueue(){
        a = (Item[]) new Object[1];
    }

    private void resize(int newcap){
        Item[] b = (Item[]) new Object[newcap];
        for(int i = 0; i < N ; i++){
            b[i] = a[i];
        }
        a = b;
        System.out.println("recap!!!!!! cap:" + newcap);
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
    public void insert(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
        //N++;
    }
    public Item delete(int k){
        if(N>0 && N == a.length/4) {
            resize(a.length/2);
        }
        Item item = a[k-1];
        for(int i = k-1; i < N - 1; i++){
            //Item temp = a[i];
            a[i] = a[i + 1];
        }
        a[N - 1] = null;
        N--;
        return item;
    }
    public Iterator<Item> iterator(){
        return new GeneralizedQueueIterator();
    }

    private class GeneralizedQueueIterator implements Iterator<Item>{
        private int index = 0;

        public boolean hasNext(){
            return index < N;
        }
        public void remove(){}
        public Item next(){
            return a[index++];
        }
    }
}