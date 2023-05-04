package queue;

import java.util.Stack;

public class QueueWithStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.push(item);
    }

    private void moveStack1ToStack2(){
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
    }

    private boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        if(stack2.isEmpty()){
            moveStack1ToStack2();
        }

        return stack2.pop();
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        if(stack2.isEmpty()){
            moveStack1ToStack2();
        }

        return stack2.peek();
    }

}
