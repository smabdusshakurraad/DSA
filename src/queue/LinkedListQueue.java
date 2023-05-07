package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListQueue {
    private List<Integer> list = new ArrayList<>();

    public void enqueue(int item){
        list.add(item);
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return list.remove(0);
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        return list.get(0);
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString(){
        return Arrays.toString(list.toArray());
    }
}
