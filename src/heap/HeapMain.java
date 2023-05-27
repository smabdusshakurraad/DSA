package heap;

import java.util.Arrays;

public class HeapMain {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);

        heap.remove();

        heap.print();

        System.out.println("Heap Sorting");
        int[] numbers = {5, 3, 10, 1, 4, 2 };

        var heapSort = new Heap();

        for(var number : numbers){
            heapSort.insert(number);
        }

        for(int i = 0; i< numbers.length; i++){
            numbers[i] = heapSort.remove();
        }
        System.out.println("Descending orders: " + Arrays.toString(numbers));

        for(int i = numbers.length - 1; i > -1; i--){
            numbers[i] = heap.remove();
        }
        System.out.println("Ascending Order: " + Arrays.toString(numbers));

        int[] items = { 5, 3, 8, 4, 1, 2};
        MaxHeap.heapify(items);
        System.out.println("Heapify: " + Arrays.toString(items));

        items = new int[]{5, 3, 8, 4, 1, 2};
        System.out.println("Kth Largest Item: " + MaxHeap.kthLargestItem(items, 5));
    }
}
