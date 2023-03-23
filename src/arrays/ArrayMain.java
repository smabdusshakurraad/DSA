package arrays;

import java.util.ArrayList;
import java.util.Arrays;

// array is fixed size
// assigning a value to an array index is O(1)
// inserting a value while the array is full O(n)
// deleting the first value (worst case) is O(n)
public class ArrayMain {
    public static void main(String[] args) {
        // declaring a fixed sized array
        int[] array = new int[3];
        // printing the type of array and the location
        System.out.println(array);
        // printing array elements
        System.out.println(Arrays.toString(array));
        // assigning values
        array[0] = 10;
        array[1] = 20;
        array[2] = 30;
        System.out.println(Arrays.toString(array));
        // declaring and initializing the array
        int[] array2 = {40, 50, 60};
        System.out.println(Arrays.toString(array2));
        // print the size of the array
        System.out.println(array.length);

        //-------------------------------------
        // 2 types of dynamic array in java
        /**
         *  vector - grow 100% of it's size when the array is full
         *  and vector is synchronized
         *
         *  arrayList - grow 50% of it's size when the array is full
         *  arrayList is asynchronized
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        System.out.println(arrayList);
        arrayList.remove(0);
        arrayList.add(20);
        System.out.println(arrayList.indexOf(20));
        System.out.println(arrayList.lastIndexOf(20));
        System.out.println(arrayList.contains(2));
        System.out.println(arrayList.size());
        System.out.println(arrayList.toArray().length);
    }
}
