package com.yiqing;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class MyListFiles {

    public static void listAllFiles(String path, int dep) {
        File f = new File(path);
        File[] list = f.listFiles();
        for (File newFile : list) {
            for (int i = 0; i < dep; i++) StdOut.print("\t");
            StdOut.println(newFile.getName());
            if (newFile.isDirectory()) {
                listAllFiles(newFile.getAbsolutePath(), dep + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = "/Users/yiqingzhang/Programming/Java/Learning/src/com/yiqing";
        StdOut.println(path);
        listAllFiles(path, 0);
    }
}