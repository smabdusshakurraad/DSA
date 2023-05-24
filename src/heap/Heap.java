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

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp(){
        int index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
