package stacks;

import java.util.Arrays;

public class TwoStack {
    private int[] items ;//= new int[10];
    private int count1;
    private int count2;

    public TwoStack(){
        items = new int[10];
        count1 = 0;
        count2 = items.length;
    }

    public TwoStack(int length){
        items = new int[length];
        count1 = 0;
        count2 = items.length;
    }
    private boolean isEmpty2() {
        return count2 == items.length;
    }
    private boolean isEmpty1() {
        return count1 == 0;
    }
    public int pop1(){
        if(isEmpty1()){
            throw new IllegalStateException();
        }
        return items[--count1];
    }

    public int pop2(){
        if(isEmpty2()){
            throw new IllegalStateException();
        }
        return items[count2++];
    }

    public void push1(int item){
        if(isFull1()){
            throw new IndexOutOfBoundsException();
        }
        items[count1++] = item;
    }

    public void push2(int item){
        if(isFull2()){
            throw new IndexOutOfBoundsException();
        }
        items[--count2] = item;
    }

    public int peek1(){
        if(isEmpty1()){
            throw new IllegalStateException();
        }
        return items[count1 - 1];
    }

    public int peek2(){
        if(isEmpty2()){
            throw new IllegalStateException();
        }
        return items[count1 + 1];
    }

    public boolean isFull1(){
        return count1 == count2;
    }

    public boolean isFull2(){
        return count1 == count2;
    }

    public String toString1(){
        int[] stack = Arrays.copyOfRange(items, 0, count1);
        return Arrays.toString(stack);
    }

    public String toString2(){
        int[] stack = Arrays.copyOfRange(items, count2, items.length);
        return Arrays.toString(stack);
    }

}
