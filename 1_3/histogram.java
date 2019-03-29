package com.yiqing;

public class histogram {
    public static int[] histogram (int[] a, int M){
        int[] his = new int[M];
        int count = 0;
        for(int i = 0;i < M;i++){
            for(int j = 0;j < a.length; j++){
                if(a[j]==i){
                    count++;
                }
            }
            his[i] = count;
            count = 0;
        }
        return his;
    }
}
