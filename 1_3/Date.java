package com.yiqing;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

public class Date {
    private int mouth;
    private int day;
    private int year;

    public Date(String date){
        String[] fields = date.split("/");
        mouth = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
    }

    public String toString(){
        return "" + mouth + "/" + day + "/" + year;
    }
    public static Date[] readDates(String name){
        In in = new In(name);
        Queue<Date> q = new Queue<Date>();
        while (!in.isEmpty())
        {
            String s = in.readString();
            Date date = new Date(s);
            q.enqueue(date);
        }
        int N = q.size();
        Date[] a = new Date[N];
        for(int i = 0; i < N; i++){
            a[i] = q.dequeue();
        }
        return a;
    }


    public static void main(String arg[]) {
        //System.out.println("Input:");
        //String s = StdIn.readString();
        String filePathString = System.getProperty("user.dir");

        String dateFileString = filePathString
                + "/src/com/yiqing/" + "date.txt";
        System.out.println("即将读取" + dateFileString + "文件中得到的数组为：");
        Date[] date = readDates(dateFileString);
        for(int i = 0; i< date.length; i++){
            System.out.println(i);
        }
    }

}
