package com.yiqing;

public class StackProblem2 {
     private Node first;
     private int N;
     private class Node{
         int number;
         Node next;
     }

     public boolean isEmpty(){
         return first == null;
     }

     public int size(){
         return N;
     }

     private boolean check(int c){
         if(N < 2) return true;
         Node current = first;
         int min1 = current.number;
         int min2 = current.number;
         while (current.next != null){
             if(min1 > current.next.number){
                 min2 = min1;
                 min1 = current.next.number;
             }else if (min2 > current.next.number){
                 min2 = current.next.number;
             }
             current = current.next;
         }
         if(min1 == min2) return true;
         if(c > min2) return false;
         else return true;
     }

     public void push(int c){
         if(!check(c)) {
             System.out.println("Cant insert!" + " size: " + size());
             return;
         }
         Node oldfirst = first;
         first = new Node();
         first.number = c;
         first.next = oldfirst;
         N++;
         System.out.println("Insert! " + c);

     }
     public static void main (String[] args){
         StackProblem2 s = new StackProblem2();
         s.push(9);
         s.push(2);
         s.push(4);
         s.push(7);
         s.push(3);
         s.push(9);
         s.push(1);
     }


}
