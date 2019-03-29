package com.yiqing;

public class QueueStack<Item>  {
    private Stack<Item> s = new Stack<Item>();
    private Stack<Item> st = new Stack<Item>();

    public boolean isEmpty(){
        return s.isEmpty() && st.isEmpty();
    }
    public int size(){
        return s.size() + st.size();
    }

    public void enqueue(Item item){
        s.push(item);
    }
    public Item dequeue(){
        while (!s.isEmpty()){
            st.push(s.pop());
        }
        Item item = st.pop();
        while (!st.isEmpty()){
            s.push(st.pop());
        }
        return item;
    }


    public static void main(String[] args){
        QueueStack<String> s = new QueueStack<String>();
        System.out.println(s.isEmpty());
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        for(String i:s.s){
            System.out.println(i);
        }
        while (!s.isEmpty()){
            System.out.println(s.dequeue());
        }
    }
}
