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
        queue.add(40);
        queue.add(50);
//        var front = queue.remove();
//        System.out.println(front);
        System.out.println(queue);
//        reverse(queue);
        System.out.println();

        // Queue using Array
        System.out.println("Array Queue");
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
        System.out.println();


        System.out.println("Stack Queue");
        QueueWithStack queueWithStack = new QueueWithStack();

        queueWithStack.enqueue(10);
        queueWithStack.enqueue(20);
        queueWithStack.enqueue(30);

        var first = queueWithStack.dequeue();
        System.out.println(first);

        var peek = queueWithStack.peek();
        System.out.println(peek);
        System.out.println();


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
        System.out.println();

        System.out.println("Queue reverser");
        QueueReverser.reverseRecursion(queue, 3);
        System.out.println(queue);
        System.out.println();

        System.out.println("Linked List Queue");
        LinkedListQueue linkedListQueue = new LinkedListQueue();

        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);

        linkedListQueue.dequeue();
        System.out.println(linkedListQueue.peek());
        System.out.println(linkedListQueue.toString());
        System.out.println();

        System.out.println("Stack Using two queues");
        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        stackUsingTwoQueues.push(10);
        stackUsingTwoQueues.push(20);
        stackUsingTwoQueues.push(30);

        System.out.println(stackUsingTwoQueues.pop());
        System.out.println();

        System.out.println("Priority queue using heap");
        PriorityQueueWithHeap priorityQueueWithHeap = new PriorityQueueWithHeap();
        priorityQueueWithHeap.enqueue(10);
        priorityQueueWithHeap.enqueue(20);
        priorityQueueWithHeap.enqueue(30);

        System.out.println(priorityQueueWithHeap.dequeue());
        System.out.println();


        System.out.println("Min Priority queue using Min heap");
        MinPriorityQueueWithHeap minPriorityQueueWithHeap = new MinPriorityQueueWithHeap();
        minPriorityQueueWithHeap.add("Raad",10);
        minPriorityQueueWithHeap.add("Rk",20);
        minPriorityQueueWithHeap.add("Tareq", 30);

        System.out.println(minPriorityQueueWithHeap.remove());
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
