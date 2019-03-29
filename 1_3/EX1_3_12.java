package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class EX1_3_12 {
    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        while(!StdIn.isEmpty()){
            if(s.size() == 10) break;
            else {
                String input = StdIn.readString();
                s.push(input);
            }
        }
        System.out.println("size:" + s.size());
        //Stack<String> c = new Stack<String>();
        Stack<String> copy = copy(s);
        while(!copy.isEmpty()){
            System.out.println(copy.pop());
        }

        //for(int N = 0 : N <){
            //System.out.println(s);
        //}
    }

    public static Stack copy (Stack s){
        Stack<String> c = new Stack<String>();
        while (!s.isEmpty()){
            String item = s.pop().toString();
            c.push(item);
        }
        Stack<String> copy = new Stack<String>();
        while (!c.isEmpty()){
            String item = c.pop();
            copy.push(item);
        }
        return copy;
    }
}
