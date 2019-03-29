package com.yiqing;

import java.util.Iterator;
import java.util.ListIterator;

public class learn_Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){return N > 0;}
    public int size(){return N;}
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = item;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){return current != null;}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }
}
