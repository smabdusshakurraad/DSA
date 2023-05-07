package queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count = 0;
    private int front;
    private int rear;

    public PriorityQueue(){
        items = new int[5];
    }

    public PriorityQueue(int size){
        items = new int[size];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        count--;
        return items[front++];
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return items[count--];
    }

    public void enqueue(int item){
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }

        var index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    }

    public int shiftItemsToInsert(int item){
        int i;
        for(i = count - 1; i >= 0; i--){
            if(items[i] > item){
                items[i+1] = items[i];
            }else {
                break;
            }
        }

        return i+1;
    }

    private boolean isFull() {
        return count == items.length;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
