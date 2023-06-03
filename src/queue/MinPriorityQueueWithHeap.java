package queue;

import heap.MinHeap;

public class MinPriorityQueueWithHeap {
    private MinHeap minHeap = new MinHeap();

    public void add(String value, int priority){
        minHeap.insert(priority, value);
    }
    public int remove(){
        return minHeap.remove();
    }
    public boolean isEmpty(){
        return minHeap.isEmpty();
    }
}
