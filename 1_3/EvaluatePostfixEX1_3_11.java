package com.yiqing;

import edu.princeton.cs.algs4.StdIn;

public class EvaluatePostfixEX1_3_11 {
    public static void main(String[] args){
        Stack<String> data = new Stack<String>();
        //Stack<String> op = new Stack<String>();

        String input = StdIn.readString();
        String[] inputs = input.split("");
        for(String i : inputs){
            if(i.equals("0") || i.equals("1")|| i.equals("2")|| i.equals("3")|| i.equals("4")||
                    i.equals("5")|| i.equals("6")|| i.equals("7")|| i.equals("8")|| i.equals("9")){
                data.push(i);
            }
            else if(i.equals("+")|| i.equals("-")|| i.equals("*")|| i.equals("/")){
                String s1 = data.pop();
                String s2 = data.pop();
                int d2 = Integer.parseInt(s1);
                int d1 = Integer.parseInt(s2);
                int d3 = 0;
                if(i.equals("+")) d3 = d1 + d2;
                if(i.equals("-")) d3 = d1 - d2;
                if(i.equals("*")) d3 = d1 * d2;
                if(i.equals("/")) d3 = d1 / d2;
                String d4 = String.valueOf(d3);
                data.push(d4);
            }
        }
        System.out.println(data.pop());
    }
}
