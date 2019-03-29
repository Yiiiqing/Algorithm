package com.yiqing;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfixEX1_3_10 {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();

        String input = StdIn.readString();
        String[] inputs = input.split("");
        for (String i : inputs) {
            if (i.equals("0") || i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4") ||
                    i.equals("5") || i.equals("6") || i.equals("7") || i.equals("8") || i.equals("9")) {
                StdOut.print(i);
            } else if (i.equals("(")) {
                s.push(i);
            } else if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                if(!s.isEmpty()){
                    String stacktop = s.peek();
                    if (stacktop.equals("*") || stacktop.equals("/") && i.equals("+") || i.equals("-")) {
                        if (!stacktop.equals("(")) {
                            StdOut.print(s.pop());
                        }
                    }
                }
                s.push(i);
            } else if (i.equals(")")) {
                if (s.isEmpty()) StdOut.print("ERROR");
                else {
                    String opt = s.pop();
                    while (!opt.equals("(")) {
                        StdOut.print(opt);
                        opt = s.pop();
                    }
                }
            }
        }
        while(!s.isEmpty()){
            StdOut.print(s.pop());
        }
    }
}
