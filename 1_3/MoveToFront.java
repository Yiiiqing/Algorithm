package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import java.util.ListIterator;

public class MoveToFront<Item> implements Iterable<Item> {
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
        if (last == null) {
            Node node = new Node();
            node.item = item;
            last = node;
            if (first == null)
                first = node;
            N++;
        } else {
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

    public Item popRight() {
        Item item = last.item;
        last = oldlast;
        N--;
        return item;
    }

    public void pushLeft(Item item) {
        if (first == null) {
            Node node = new Node();
            node.item = item;
            first = node;
            if (last == null)
                last = node;
            N++;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }
    }

    public void Printout() {
        Node current;
        current = first;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }


    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public boolean delete(Item target){
        Node current = first;
        while (current.next != null) {
            if (current.item.equals(target)) {
                first = first.next;
                N--;
                return true;
            } else {
                if (current.next.item.equals(target)) {
                    current.next = current.next.next;
                    N--;
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        private int i;
        public boolean hasNext() {
            return i < N;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            i++;
            return item;
        }

    }

    public static void main(String[] args) {
        System.out.println("Input Strings");
        String input = StdIn.readLine();
        //System.out.println(input);
        String[] inputs = input.split(" ");
        MoveToFront<String> mtf = new MoveToFront<String>();
        for (String i : inputs) {
            //System.out.println("Doing " + i);
            if(mtf.size() == 0){
                mtf.pushLeft(i);
                //System.out.println(mtf.size());
            }

            else{
                mtf.delete(i);
                mtf.pushLeft(i);
                //System.out.println(mtf.size());
            }
        }
        for(String s : mtf){
            System.out.println(s);
        }
    }
}
