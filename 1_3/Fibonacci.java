package com.yiqing;

public class Fibonacci {
    public static long F(long[] Fibonacci, int N){

        if (N == 0) {
            Fibonacci[0] = 0;
            return Fibonacci[N];
        }
        else if(N == 1) {
            Fibonacci[1] = 1;
            return Fibonacci[N];
        }
        else{
            //System.out.println("got here");
            Fibonacci[N] = Fibonacci[N-2] + Fibonacci[N-1];
            //System.out.println("N = " + Fibonacci[N]);
            return Fibonacci[N];
        }
    }
    public static void main(String[] args){
        long[] Fibonacci = new long[100];
        for (int N = 0; N < 100; N++){
            System.out.println(N + " " + F(Fibonacci,N));
        }
    }
}
