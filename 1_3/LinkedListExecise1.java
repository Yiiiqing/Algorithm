package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class LinkedListExecise1<Item> {

    private static class Node<Item>{
        Node<Item> next;
        Item item;
    }

    public Node<Item> deleteLastNode(Node<Item> first){
        if(first == null){
            return null;
        }
        Node<Item> current = first;
        if(current.next == null){
            first = null;
            return first;
        }
        Node<Item> secondLast = first;
        while (current.next != null){
            secondLast = current;
            current = current.next;
        }
        secondLast.next = null;
        return first;
    }
    public Node<Item> delete(int k, Node<Item> first) {
        Node<Item> current = first;
        if(k<0 || first == null) return null;
        if(k == 1){
            first = first.next;
            return first;
        }
        for (int i = 2; i < k; i++)
            current = current.next;
        current.next = current.next.next;
        return first;
    }
    public boolean find(Node<Item> first, String key){
        Node<Item> current = first;
        while (current.next!= null){
            System.out.println("finding!");
            if(current.item.equals(key)) return true;
            current = current.next;
        }
        return false;
    }

    public Node<Item> removeAfter(Node<Item> node, Node<Item> first){
        if(first == null||node == null){
            return first;
        }
        Node current = first;
        while (current!= null){
            if(current.item.equals(node.item)){
                if(current.next == null){
                    return first;
                }
                else {
                    current.next = current.next.next;
                    return first;
                }
            }
            current = current.next;
        }
        return first;
    }
    public Node<Item> insertAfter(Node<Item> first,Node<Item> node,Node<Item> insert){
        if(node == null||insert == null){
            return first;
        }
        Node<Item> current = first;
        while (current != null){
            if(current.equals(node)){
                insert.next = current.next;
                current.next = insert;
                return first;
            }
            current = current.next;
            System.out.println(current.item);
        }
        return first;
    }
    public Node<Item> remove(Node<Item> first, String key){
        if(first.item.equals(key))
            first = first.next;
        Node<Item> current = first.next;
        Node<Item> lastcurrent = first;
        while (current != null){
            if(current.item.equals(key)){
                lastcurrent.next = lastcurrent.next.next;
            }
            lastcurrent = current;
            current = current.next;
        }
        return first;
    }


    public static void main(String[] args){
        Node<String> first = new Node<String>();
        Node<String> second = new Node<String>();
        Node<String> third = new Node<String>();
        Node<String> forth = new Node<String>();
        Node<String> fifth = new Node<String>();
        first.item = "我的";
        second.item = "名字";
        third.item = "叫";
        forth.item = "小白的";
        fifth.item = "一清";
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = null;

        System.out.println("原链表：\n-------");
        Node current1 = first;
        while (current1.next != null){
            System.out.println(current1.item);
            current1 = current1.next;
        }
        System.out.println(current1.item);
        System.out.println("-------");

        LinkedListExecise1<String> linkedListExercise1 = new LinkedListExecise1<String>();
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
        Node<String> resultNode = linkedListExercise1.remove(first,"小白的");
        System.out.println("新链表：\n-------");
        Node current2 = resultNode;
        while (current2.next != null){
            System.out.println(current2.item);
            current2 = current2.next;
        }
        System.out.println(current2.item);
        System.out.println("-------");

    }
}



