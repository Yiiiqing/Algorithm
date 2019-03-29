package com.yiqing;

import java.util.Iterator;
import java.util.ListIterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private Node oldlast;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
    public void pushRight(Item item) {
        if(last == null){
            Node node = new Node();
            node.item = item;
            last = node;
            if(first == null)
                first = node;
            N++;
        }
        else {
            oldlast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
            N++;
        }
    }

    public Item popLeft() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public Item popRight(){
        Item item = last.item;
        last = oldlast;
        N--;
        return item;
    }
    public void pushLeft(Item item) {
        if(first == null){
            Node node = new Node();
            node.item = item;
            first = node;
            if(last == null)
                last = node;
            N++;
        }
        else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }
    }
    public void Printout(){
        Node current;
        current = first;
        while (current != null){
            System.out.println(current.item);
            current = current.next;
        }
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}