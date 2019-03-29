package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class Josephus{
    public static void main(String[] args) {
        System.out.println("input number of people:");
        int N = StdIn.readInt();
        System.out.println("input death number");
        int M = StdIn.readInt();
        Queue<Integer> j = new Queue<Integer>();
        for(int i = 0; i < N; i++){
            j.enqueue(i);
        }

        while (!j.isEmpty()){
            for(int i = 0; i < M - 1 ;i++){
                j.enqueue(j.dequeue());
            }
            System.out.println(j.dequeue());
        }
    }

}
