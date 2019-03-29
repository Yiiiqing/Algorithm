package com.yiqing;

import java.util.Iterator;
import java.util.ListIterator;

public class GeneralizedQueueLinkedList<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void insert(Item item){
        Node oldlast  = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
    public void addhead(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item delete(int k){
        Node current = first;
        Node delete;
        for(int i = 0 ; i < k - 2;i++ ){
            current = current.next;
        }
        delete = current.next;
        current.next = current.next.next;
        N--;
        return delete.item;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
