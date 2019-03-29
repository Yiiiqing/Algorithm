package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class ReverseLinkedList<Item> {
    public static class Node<Item> {
        Node next;
        Item item;
    }

    public static Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public static void main(String[] args) {
        /**
         * 创建链表
         */
        Node<String> first = new Node<String>();
        Node<String> second = new Node<String>();
        Node<String> third = new Node<String>();
        Node<String> forth = new Node<String>();
        Node<String> fifth = new Node<String>();
        first.item = "张一清";
        first.next = second;
        second.item = "的";
        second.next = third;
        third.item = "爱";
        third.next = forth;
        forth.item = "是";
        forth.next = fifth;
        fifth.item = "白玲郡";
        fifth.next = null;


        //System.out.println("原链表：\n-------");
        ReverseLinkedList.Node current1 = first;
        while (current1.next != null) {
            System.out.println(current1.item);
            current1 = current1.next;
        }
        System.out.println(current1.item);
        System.out.println("-------");

        //System.out.println("倒过来！");
        if(StdIn.readString().equals("倒过来")) {
            System.out.println("-------");
            Node newFirst = reverse(first);
            Node current = newFirst;
            while (current != null) {
                System.out.println(current.item);
                current = current.next;
            }
        }
    }
}
