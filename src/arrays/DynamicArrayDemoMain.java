package arrays;

import java.util.Arrays;

public class DynamicArrayDemoMain {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(3);
        dynamicArray.insert(10);
        dynamicArray.insert(20);
        dynamicArray.insert(30);
        dynamicArray.insert(40);
        dynamicArray.print();
        System.out.println(dynamicArray.indexOf(20));
        System.out.println(dynamicArray.indexOf(100));
        dynamicArray.removeAt(2);
        dynamicArray.removeAt(1);
        dynamicArray.removeAt(0);
        dynamicArray.print();
        dynamicArray.insert(300);
        dynamicArray.print();
        System.out.println("Maximum value: "+ dynamicArray.max());
        dynamicArray.reverse();
        dynamicArray.print();
        dynamicArray.insertAt(50,0);
        dynamicArray.print();
        int[] newArray = {40, 50};
        newArray =  dynamicArray.intersect(newArray);
        System.out.println(Arrays.toString(newArray));
    }
}
