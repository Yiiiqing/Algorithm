package com.yiqing;

public class _try {

    public static void main(String arg[]) {
        DequeDoubleStack<String> d = new DequeDoubleStack<String>();

        d.pushRight("11");
        d.pushRight("12");
        d.pushRight("13");

        d.pushLeft("1");
        d.pushLeft("2");
        d.pushLeft("3");
        d.pushLeft("4");
        d.pushRight("14");
        d.pushLeft("3");
        d.pushLeft("4");
        d.pushLeft("5");
        d.pushLeft("6");
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println("---------");
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popLeft());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
        System.out.println(d.popRight());
        System.out.println("size: " + d.size()+ " size1: " + d.size1() + " size2: " + d.size2());
    }
}
