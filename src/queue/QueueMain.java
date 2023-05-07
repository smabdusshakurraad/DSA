package queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        var front = queue.remove();
        System.out.println(front);
        System.out.println(queue);
        reverse(queue);

        // Queue using Array
        ArrayQueue arrayQueue = new ArrayQueue();
//        arrayQueue.dequeue();
        arrayQueue.print();
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(20);
        arrayQueue.enqueue(30);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
        arrayQueue.dequeue();
        arrayQueue.enqueue(60);
        System.out.println(arrayQueue.dequeue());
        arrayQueue.print();
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.peek());
        arrayQueue.print();


        System.out.println("Stack Queue");
        QueueWithStack queueWithStack = new QueueWithStack();

        queueWithStack.enqueue(10);
        queueWithStack.enqueue(20);
        queueWithStack.enqueue(30);

        var first = queueWithStack.dequeue();
        System.out.println(first);

        var peek = queueWithStack.peek();
        System.out.println(peek);


        System.out.println("Priority queue");
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.enqueue(10);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(2);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(1);
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.remove());

        System.out.println(priorityQueue);


    }

    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while (!stack.empty()){
            queue.add(stack.pop());
        }

        System.out.println(queue);
    }
}
