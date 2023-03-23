package arrays;

import java.util.Arrays;

public class DynamicArray {
    private int count = 0;
    private int size;
    private int[] array;
    public DynamicArray(int length){
        this.size = length;
        array = new int[size];
    }
    private void increaseSize(int size){
        array = Arrays.copyOf(array, size);
    }
    public void insert(int value){
        if(count>=size){
            size += 10;
            increaseSize(size);
        }
        array[count++] = value;
    }
    public int indexOf(int value){
        for(int i = 0; i<count; i++){
            if(array[i] == value){
                return i;
            }
        }
        return -1;
    }
    public void removeAt(int index){
        if(index<0 || index>= count){
            throw new IllegalArgumentException();
        }
        for(int i = index; i<count - 1; i++){
            array[i] = array[i+1];
        }
        count--;
    }
    public void print(){
        for(int i =0; i<count; i++){
            System.out.println(array[i]);
        }
    }

    /**
     * Exercise
     */
    public int max(){
        int max = 0;
        for(int i=0;i<count;i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public int[] intersect(int[] anotherArray){
        int size = Math.max(anotherArray.length, count);
        int[] result = new int[size];
        int index = 0;
        for(int i =0; i < count; i++){
            for (int j = 0; j < anotherArray.length; j++){
                if(array[i] == anotherArray[j]){
                    System.out.println(anotherArray[j]);
                    result[index] = anotherArray[j];
                    index++;
                    break;
                }
            }
        }
        return result;
    }

    public void reverse(){
        for (int i =0; i<count/2; i++){
            array[i] += array[count-i-1];
            array[count-i-1] = array[i] - array[count-i-1];
            array[i] -= array[count-i-1];
        }
    }

    public void insertAt(int item, int index){
        if(index < 0 || index >= count){
            throw new IllegalArgumentException();
        }
        count++;
        for(int i = count - 1; i > index; i--){
            array[i] = array[i-1];
        }
        array[index] = item;
    }
}
