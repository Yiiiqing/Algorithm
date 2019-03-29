package com.yiqing;

import java.util.Iterator;

public class CircularLinkedListQueue<Item> implements Iterable<Item>{
    private class Node<Item>{
        Item item;
        Node<Item>  next;
    }

    private Node<Item> last;
    private int N = 0;

    public void enqueue(Item item){
        Node<Item> node = new Node<Item>();
        node.item = item;
        if(this.isEmpty()){
            node.next = node;
            last = node;
            N++;
        }
        else {
            node.next = last.next;
            last.next = node;
            last = node;
            N++;
        }
    }
    public Item dequeue(){
        if(this.isEmpty()){
            return null;
        }
        Node<Item> first = last.next;
        last.next = last.next.next;
        N--;
        return first.item;
    }

    public boolean isEmpty(){
        return last == null;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item>{
        int count = 0;
        Node<Item> current = last;
        public void remove(){}
        public Item next(){
            current = current.next;
            count++;
            return current.item;
        }
        public boolean hasNext() {
            if (last == null) return false;
            if(count < N){
                return true;
            }
            return false;
        }
    }
}