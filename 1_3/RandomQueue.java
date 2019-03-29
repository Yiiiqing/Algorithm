package com.yiqing;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item>{
    private Item[] a;
    int N;

    public RandomQueue(){
        a = (Item[]) new Object[1];
    }

    private void resize(int newcap){
        Item[] b = (Item[]) new Object[newcap];
        for(int i = 0; i < N ; i++){
            b[i] = a[i];
        }
        a = b;
        System.out.println("recap! cap:" + newcap);
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
        }
        a[N++] = item;
        //N++;
    }
    public Item dequeue(){
        if(N>0 && N == a.length/4) {
            resize(a.length/2);
        }
        int i = StdRandom.uniform(N);
        System.out.println(i);
        Item temp = a[i];
        a[i] = a[N-1];
        a[N-1] = temp;
        a[N-1] = null;
        N--;
        return temp;
    }
    public Item sample(){
        int i = StdRandom.uniform(N);
        return a[i];
    }

    public Iterator<Item> iterator(){
        return new RandomQueueIterator();
    }
    private class RandomQueueIterator implements Iterator<Item>{
        private Item[] temp;
        private int index;
        public RandomQueueIterator(){
            temp = (Item[]) new Object[N];
            for(int i = 0; i < N; i++){
                temp[i] = a[i];
            }
            StdRandom.shuffle(temp);
            index = 0;
        }
        public void remove(){}

        @Override
        public boolean hasNext() {

            return index < N;
        }

        @Override
        public Item next() {
            return temp[index++];
        }
    }

    public static void main(String arg[]) {
        RandomQueue<Integer> queue = new RandomQueue<Integer>();
        for (int i = 1; i <= 52; i++)
            queue.enqueue(i);

        for (Integer i : queue) {
            System.out.println(i);
        }
    }
}
