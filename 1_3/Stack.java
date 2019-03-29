package com.yiqing;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private int count;

    private class Node{
        Item item;
        Node next;
    }
    public Stack(){

    }
    public Stack(Stack<Item> s){
        Stack<Item> t = new Stack<Item>();
        Stack<Item> temp = new Stack<Item>();
        int size = s.size();
        for(int i = 0; i < size; i++){
            temp.push(s.pop());
        }
        for(int i = 0; i < size; i++){
            Item item = temp.pop();
            t.push(item);
            s.push(item);
        }
        this.first = t.first;
        this.N = t.N;
    }
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        count++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        count--;
        return item;
    }
    public Item peek(){
        Item item = first.item;
        return item;
    }
    public Stack<Item> catenation(Stack<Item> stack2){
        Stack<Item> s2copy = new Stack<Item>(stack2);
        Stack<Item> temp = new Stack<Item>();
        while (!s2copy.isEmpty()){
            temp.push(s2copy.pop());
        }
        while (!temp.isEmpty()){
            this.push(temp.pop());
        }
        return this;
    }
    public Iterator<Item> iterator() throws java.util.ConcurrentModificationException{
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
//        public ListIterator(){
////            int push;
////        }
        int c = count;
        private Node current = first;
        public boolean hasNext(){
            if(c != count) throw new ConcurrentModificationException();
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
