package com.yiqing;

import java.util.Iterator;

public class Buffer implements Iterable {
    Stack<Character> front = new Stack<Character>();//光标前
    Stack<Character> after = new Stack<Character>();//光标后
    public int size(){
        return front.size() + after.size();
    }
    public char delete(){
        char delete = front.pop();
        return delete;
    }
    public void insert(char c){
        front.push(c);
    }
    public void left(int k){
        if(k > front.size()){
            k = front.size();
        }
        for(int i = 0; i < k; i++){
            after.push(front.pop());
        }
    }
    public void right(int k){
        if(k > after.size()){
            k = after.size();
        }
        for(int i = 0; i < k; i++){
            front.push(after.pop());
        }
    }

    public Iterator iterator(){
        return new BufferIterator();
    }
    private class BufferIterator implements Iterator{
        private int index;
        Stack<Character> temp = new Stack<Character>(after);
        public BufferIterator(){
            for(Character c : front){
                temp.push(c);
            }
        }
        public void remove(){}
        public boolean hasNext(){
            return index < size();
        }
        public Character next(){
            index++;
            return temp.pop();

        }
    }
}