package com.yiqing;

public class RingBuffer<Item> {

    public Item[] a = null;
    public int writePos = 0;
    public int available = 0;
    public int capacity = 0;

    public RingBuffer(int cap){
        this.capacity = cap;
        this.a = (Item[]) new Object[capacity];
    }
    public void reset(){
        this.writePos = 0;
        this.available = 0;
    }

    public int capacity(){
        return this.capacity;
    }
    public int available(){
        return this.available;
    }

    public int remainingCapicity(){
        return this.capacity - this.available;
    }
    public boolean put(Item item){
        if(available < capacity){
            if(writePos >= capacity){
                writePos = 0;
            }
            a[writePos] = item;
            writePos++;
            available++;
            return true;
        }
        return false;
    }
    public Item take(){
        if(available==0){
            return null;
        }
        int nextSlot = writePos - available;
        if(nextSlot < 0){
            nextSlot = capacity + nextSlot;
        }
        Item item = a[nextSlot];
        available--;
        return item;
    }
}
