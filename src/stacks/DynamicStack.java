package stacks;

import java.util.Arrays;

public class DynamicStack {
    int[] stack;
    int size;
    int count = 0;
    public DynamicStack(int size){
        this.size = size;
        stack = new int[size];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void push(int item){
        if(count >= size){
            size *= 2;
            stack = Arrays.copyOf(stack, size);
        }
        stack[count++] = item;
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return stack[--count];
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return stack[count - 1];
    }
    @Override
    public String toString(){
        int[] items = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(items);
    }
}
