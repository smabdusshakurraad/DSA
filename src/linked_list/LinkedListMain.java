package linked_list;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeFirst();
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(10));
        System.out.println(list.size());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
