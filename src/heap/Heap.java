package heap;

import java.util.Arrays;

public class Heap {
    private int[] items;
    private int size;

    public Heap(){
        this.items = new int[10];
    }

    public void insert(int item){
        if(isFull())
            throw new IllegalStateException();

        items[size++] = item;

        if(size > 0){
            bubbleUp();
        }
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();

        int removed = items[0];

        items[0] = items[--size];
        bubbleDown();

        return removed;
    }

    public boolean isFull() {
        return size == items.length;
    }
    private void bubbleUp(){
        int index = size - 1;
        while (index > 0 && items[index] > items[parentIndex(index)]){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    private void bubbleDown(){
        int index = 0;
        while (index < size - 1 &&  !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }
    private int largerChildIndex(int index) {
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;

        boolean valid = items[index] >= leftChild(index);

        if(hasRightChild(index))
         valid &= items[index] >= rightChild(index);

        return valid;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int parentIndex(int index){
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index){
        return 2 * index + 1;
    }

    private int rightChildIndex(int index){
        return 2 * index + 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public void print() {
        for(int i = 0; i < size; i++){
            System.out.print(items[i] + ", ");
        }
        System.out.println();
    }
}
