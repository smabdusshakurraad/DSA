package queue;

import java.util.Arrays;

public class ArrayQueue {
    private  int[] queue;
    private int front = 0;
    private int rear = 0;
    private int count;
    public ArrayQueue(){
        queue = new int[5];
    }

    public ArrayQueue(int size){
        queue = new int[size];
    }
    public boolean isFull(){
        return count == queue.length;
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public void enqueue(int item){
        if(isFull()){
            throw new IllegalStateException();
        }
        queue[rear] = item;
        rear = (rear+1) % queue.length;
        count++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        var item =  queue[front];
        queue[front] = 0;

        front = (front + 1) % queue.length;

        count--;

        return item;
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        return queue[front];
    }

//    @Override
//    public String toString() {
//        for(int i = front; i<rear; i++){
//            System.out.print(queue[i]);
//            System.out.print(" ");
//        }
//
//    }

    public void print(){
        for(int i = 0; i<queue.length; i++){
            System.out.print(queue[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
