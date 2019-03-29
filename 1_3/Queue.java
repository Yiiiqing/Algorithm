package com.yiqing;
import java.util.Iterator;
import java.util.ListIterator;

public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public Queue(){

    }
    public Queue(Queue<Item> q){
        Queue<Item> r = new Queue<Item>();
        int size = q.size();
        for(int i = 0; i < size; i ++) {
            Item item = q.dequeue();
            q.enqueue(item);
            r.enqueue(item);
        }
        this.first = r.first;
        this.last = r.last;
        this.N = r.size();
    }
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void enqueue(Item item){
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
    public Queue<Item> catenation(Queue<Item> q2){
        Queue<Item> temp = new Queue<Item>(q2);
        //Queue<Item> q1copy = new Queue<Item>(q);
        while (temp.size()!=0){
            this.enqueue(temp.dequeue());
        }
        return this;
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
