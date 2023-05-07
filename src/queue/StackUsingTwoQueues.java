package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int item){
        queue1.add(item);
    }

    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException();
        }

        moveQueue1ToQueue2();
        int result = queue1.poll();

        queue1 = queue2;
        queue2.clear();
        return result;
    }

    private void moveQueue1ToQueue2() {
        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        moveQueue1ToQueue2();

        int result = queue1.element();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return result;
    }

    private boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
