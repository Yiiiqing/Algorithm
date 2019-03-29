package com.yiqing;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] bag;
    int N;

    public RandomBag(){
        bag = (Item[]) new Object[1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    private void resize(int newcap){
        Item[] b = (Item[]) new Object[newcap];
        for(int i = 0; i < N ; i++){
            b[i] = bag[i];
        }
        bag = b;
    }
    public int size(){
        return N;
    }

    public void add(Item item){
        if(N == bag.length){
            resize(2*bag.length);
        }
        bag[N++] = item;
    }

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private int[] seq = new int[N];
        private int index = 0;

        public BagIterator(){
            for (int i = 0; i < seq.length; i++){
                seq[i] = i;
            }
            StdRandom.shuffle(seq);
        }
        public void remove(){}
        public boolean hasNext(){
            return index < N;
        }
        public Item next(){
            return bag[seq[index++]];
        }

    }
}

