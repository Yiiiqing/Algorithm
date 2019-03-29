package com.yiqing;

public class toBinaryString {
    public static String toBinaryString(int N){
        String s = "";
        for( int n = N; n > 0; n /=2 ){
            s = (n%2)+s;
        }
        return s;
    }
}
