package com.yiqing;

public class DequeDoubleStack<Item> {
    private Node first1;
    private Node first2;
    private Node last1;
    private Node last2;
    private Node oldfirst1;
    private Node oldfirst2;
    private int N;
    private int N1 = 0;
    private int N2 = 0;

    private class Node {
        Item item1;
        Item item2;
        Node next1;
        Node next2;
    }

    public boolean isEmpty() {
        return first1 == null && first2 == null;
    }

    public int size() {
        return N;
    }
    public int size1(){
        return N1;
    }
    public int size2(){
        return N2;
    }
    public void pushRight(Item item) {
        if(N == 0){
            Node node = new Node();
            node.item2 = item;
            first2 = node;
            if(last2 == null)
                last2 = node;
            N++;
            N2++;
        }else if(N2 >= N1){
            Node node = new Node();
            node.item2 = item;
            node.next2 = first2;
            //last2 = first2;
            first2 = node;
            N++;
            N2++;
        }
        else if(first2 == null){
            first2 = last1;
            last2 = first2;
            first2.item2 = item;
            N2++;
        }
        else {
            Node current = first1;
            for(int i = 0; i < N - N2 -1; i++){
                current = current.next1;
            }
            current.item2 = item;
            oldfirst2 = first2;
            first2 = current;
            first2.next2 = oldfirst2;
            N2++;
        }
    }
    public void pushLeft(Item item) {
        if(N == 0){
            Node node = new Node();
            node.item1 = item;
            first1 = node;
            if(last1 == null)
                last1 = node;
            N++;
            N1++;
        }else if(N1 >= N2){
            Node node = new Node();
            node.item1 = item;
            node.next1 = first1;
            first1 = node;
            N++;
            N1++;
        }
        else if(first1 == null){
            first1 = last2;
            last1 = first1;
            first1.item1 = item;
            N1++;
        }
        else if(N1 < N2){
            Node current = first2;
            for(int i = 0; i < N - N1 -1; i++){
                current = current.next2;
            }
            current.item1 = item;
            oldfirst1 = first1;
            first1 = current;
            first1.next1 = oldfirst1;
            N1++;
        }
    }
    public Item popLeft() {
        Item item = first1.item1;
        first1 = first1.next1;
        if (N1 == 1) last1 = null;
        N1--;
        if(N1 >= N2){
            N--;
        }
        return item;
    }
    public Item popRight() {
        Item item = first2.item1;
        first2 = first2.next1;
        if (N2 == 1) last2 = null;
        N2--;
        if(N2 >= N1){
            N--;
        }
        return item;
    }

//    public Iterator<Item> iterator() {
//        return new ListIterator();
//    }
//
//    private class ListIterator implements Iterator<Item> {
//        private Node current;
//
//        public boolean hasNext() {
//            return current != null;
//        }
//
//        public void remove() {
//        }
//
//        public Item next() {
//            Item item = current.item;
//            current = current.next;
//            return item;
//        }
//
//    }
public static void main(String arg[]) {
    DequeDoubleStack<String> d = new DequeDoubleStack<String>();

    d.pushRight("11");
    d.pushRight("12");
    d.pushRight("13");

    d.pushLeft("1");
    d.pushLeft("2");
    d.pushLeft("3");
    d.pushLeft("4");
    d.pushRight("14");
    d.pushLeft("3");
    d.pushLeft("4");
    d.pushLeft("5");
    d.pushLeft("6");
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println("---------");
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popLeft());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    System.out.println(d.popRight());
    System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
}
}