package com.yiqing;

import edu.princeton.cs.algs4.StdOut;

public class StackProblem1 {
    //1.3.45 栈的可生成性

    public static boolean problem1 (String[] seq){
        int cnt = 0; //栈的大小
        for(int i = 0; i < seq.length; i++){
            if(seq[i].compareTo("-")== 0) cnt--;
            else cnt++;
            if(cnt < 0) return false;
        }
        return true;
    }

    public static String[] problem2 (String[] seq){//返回操作顺序
        Stack<String> s = new Stack<String>();
        String[] ans = new String[2*seq.length];
        int N = 0;
        int p = 0;
        s.push(String.valueOf(N));
        ans[p++] = String.valueOf(N);
        N++;
        //p++;
        for(int i = 0; i < seq.length; i++){
            while (N < seq.length &&!s.peek().equals(seq[i])){//N < seq.length！！！！！！！！
                //if(!s.peek().equals(seq[i])) return null;
               s.push(String.valueOf(N));
               ans[p++] = String.valueOf(N);
               N++;
            }
            //N已经大于seq.size了，只有相等才有出的机会，所以不相等肯定是false；
            if(!s.peek().equals(seq[i])) return null;
            else{
                s.pop();
                ans[p++] = "-";
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String[] seq = new String[]{"0","1","-","-","3","-","-"};
        System.out.println(problem1(seq));
        String[] seq1 = new String[]{"2","5", "6", "7", "4", "8", "9", "3", "1", "0"};
        for(String i:problem2(seq1))
            StdOut.print(i+" ");
        String[] seq2 = new String[]{"4", "6", "8", "7", "5", "3", "2", "9", "0", "1"};

        StdOut.println("\n" + problem2(seq2));
    }
}
