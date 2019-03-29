package com.yiqing;

import java.lang.ref.SoftReference;

public class Ex1_1_17 {
    public static String exR1(int n){

        String s = exR1(n-3) + n + exR1(n - 2) + n;
        if(n<=0) return "";
        return s;
    }
}
