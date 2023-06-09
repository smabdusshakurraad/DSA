package heap;

public class MaxHeap {
    public static void heapify(int[] array){
        var lastParentIndex = array.length /2 - 1;
        for(int i = lastParentIndex; i >= 0; i--){
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index){
        var largerIndx = index;
        var leftChildIndx = 2 * index + 1;

        if(leftChildIndx < array.length &&
                array[largerIndx] < array[leftChildIndx]){
            swap(array, largerIndx, leftChildIndx);
            largerIndx = leftChildIndx;
        }

        var rightChildIndx = 2 * index + 2;
        if(rightChildIndx < array.length &&
                array[largerIndx] < array[rightChildIndx]){
            swap(array, largerIndx, rightChildIndx);
            largerIndx = rightChildIndx;
        }

        if(index == largerIndx)
            return;

        heapify(array, largerIndx);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;

    }

    public static int kthLargestItem(int[] array, int k){
        if(k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heap heap = new Heap();
        for (int itme : array){
            heap.insert(itme);
        }
        var kthItem = heap.remove();
        while (k > 1){
            kthItem = heap.remove();
            k--;
        }

        return kthItem;
    }

    public static boolean isMaxHeap(int[] array){
        for(int i = array.length / 2 -1; i > -1; i--){
            if(!validMaxHeap(array, i))
                return false;
        }
        return true;
    }

    private static boolean validMaxHeap(int[] array, int parentIndex) {
        var leftChildIndex = 2 * parentIndex + 1;
        var rightChildIndex = 2 * parentIndex + 2;
        if(leftChildIndex < array.length &&
                array[parentIndex] < array[leftChildIndex])
            return false;

        return rightChildIndex >= array.length ||
                array[parentIndex] >= array[rightChildIndex];
    }
}
