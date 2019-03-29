package com.yiqing;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX1_3_9<Item> {
    public static void main(String[] args) {
        Stack<String> data = new Stack<String>();
        Stack<String> op = new Stack<String>();
        Stack<String> reverse = new Stack<String>();
        //Queue<String> q = new Queue<String>();
        String input = StdIn.readString();
        //System.out.println(input);
        String[] inputs = input.split("");

        for (String i : inputs) {
            if (i.equals("0") || i.equals("1") ||i.equals("2") ||i.equals("3") ||i.equals("4") ||
                    i.equals("5") ||i.equals("6") ||i.equals("7") ||i.equals("8") ||i.equals("9")) {
                data.push(i);
            } else if (i.equals("+")||i.equals("-") ||i.equals("*") ||i.equals("/")) {
                op.push(i);
            } else {
                String d1 = data.pop();
                String d2 = data.pop();
                String opt = op.pop();
                String all = "(" + d2 + opt + d1 + ")";
                data.push(all);
            }
        }
        reverse.push(data.pop());
        System.out.println(reverse.pop());
    }
}