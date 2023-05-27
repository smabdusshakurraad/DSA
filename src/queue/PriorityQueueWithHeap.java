package queue;

import heap.Heap;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap();
    public void enqueue(int item){
        heap.insert(item);
    }

    public void dequeue(){
        heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public boolean isFull(){
        return heap.isEmpty();
    }
}
