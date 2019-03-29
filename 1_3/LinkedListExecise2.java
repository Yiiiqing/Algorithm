package com.yiqing;


import edu.princeton.cs.algs4.StdIn;

public class LinkedListExecise2<Item> {

    private static class Node {
        Node next;
        int item;
    }

    public int max(Node first) {
        //int max = 0;
        if (first == null)
            return 0;
        Node current = first;
        int max = current.item;
        while (current != null) {

            if (current.item > max) {
                max = current.item;
            }
            current = current.next;
        }
        return max;
    }

    public static void main(String[] args) {
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        Node forth = new Node();
        Node fifth = new Node();
        first.item = 1;
        second.item = 6;
        third.item = 65;
        forth.item = 8;
        fifth.item = 23;
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = null;

        System.out.println("原链表：\n-------");
        Node current1 = first;
        while (current1.next != null) {
            System.out.println(current1.item);
            current1 = current1.next;
        }
        System.out.println(current1.item);
        System.out.println("-------");

        LinkedListExecise2 linkedListExercise2 = new LinkedListExecise2();
        //int k = StdIn.readInt();
        //System.out.println("删除链表节点. . .");
        //Node<String> resultNode = linkedListExercise1.delete(k,first);
        //System.out.println("删除成功");
        //System.out.println("-------");

//        String key = StdIn.readString();
//        System.out.println("Finding...");
//        boolean result = linkedListExercise1.find(first,key);
//        System.out.println(result);
//
//        Node<String> insert = new Node<String>();
//        insert.item = "我爱你";
        System.out.println(linkedListExercise2.max(first));
//        System.out.println("新链表：\n-------");
//        Node current2 = resultNode;
//        while (current2.next != null){
//            System.out.println(current2.item);
//            current2 = current2.next;
//        }
//        System.out.println(current2.item);
//        System.out.println("-------");
//
//    }
    }
}



