package com.yiqing;

public class lg {
    public static int lg(int N){
        int shiftRightCount = 0;
        do{
            N >>= 1;
            shiftRightCount++;
        }while (N != 0);
        return shiftRightCount - 1;
    }
}
