package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class LastKStringEX1_3_15 {
    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        System.out.println("Input:");
        while(!StdIn.isEmpty()){
            String input = StdIn.readString();
            if(input.equals("end")){
                break;
            }
            else q.enqueue(input);
        }
        System.out.println("please input k:");
        int k = StdIn.readInt();
        int size = q.size();
        int j = size - k;
        //q.iterator();
        for(int i = 0; i < j; i++){
            q.dequeue();
        }
        System.out.println(q.dequeue());
    }

}

