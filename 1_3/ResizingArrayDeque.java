package com.yiqing;

import java.util.Iterator;

public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a;
    int N;

    public ResizingArrayDeque(){
        a = (Item[]) new Object[1];
    }

    private void resize(int newcap){
        Item[] b = (Item[]) new Object[newcap];
        for(int i = 0; i < N ; i++){
            b[i] = a[i];
        }
        a = b;
        System.out.println("recap!!!!!! + new cap:" + newcap);
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
    public void pushRight(Item item) {
        if (N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }
    public void pushLeft(Item item){
        if(N == 0){
            a[0] = item;
            N++;
        }else{
            for(int i = N; i > 0; i--){
                if(N == a.length){
                    resize(2*a.length);
                }
                a[i] = a[i-1];
            }
            a[0] = item;
            N++;
        }
    }
    public Item popleft(){
        if(N>0 && N == a.length/4) {
            resize(a.length/2);
        }
        Item item = a[0];
        N--;
        for(int i = 1; i <= N; i++){
            //Item temp = a[i];
            a[i-1] = a[i];
        }
        return item;
    }
    public Item popRight(){
        if(N>0 && N == a.length/4) {
            resize(a.length/2);
        }
        Item item = a[N--];
        return item;
    }
    public Iterator<Item> iterator(){
        return new Resizingiterator();
    }

    private class Resizingiterator implements Iterator<Item>{
        private int index = 0;
        public boolean hasNext(){
            return index != N;
        }
        public void remove(){}
        public Item next(){
            return a[index++];
        }
    }
}