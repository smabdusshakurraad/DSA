package linked_list;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;
    private boolean isEmpty(){
        return first == null;
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int value){
        Node node = new Node(value);
        if(isEmpty()){
            first = last = node;
        }
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int value){
        int index = 0;
        Node current = first;
        while (current != null){
            if(current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else{
            last = getPrevious(last);
            last.next = null;
        }
        size--;
    }
    private Node getPrevious(Node node){
        Node current = first;
        while (current != null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        int index = 0;
        Node current = first;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty()){
            return;
        }
        Node previous = first;
        Node current = first.next;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNodeFromTheEnd(int k){
        if(k <= 0 || isEmpty()){
            throw new IllegalArgumentException();
        }
        Node firstNode = first;
        Node secondNode = first;
        for(int i=0; i < k-1; i++){
            secondNode = secondNode.next;
            if(secondNode == null)
                throw new IllegalArgumentException();
        }
        while (secondNode != last){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode.value;
    }
    public void printMiddle(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        Node firstNode = first;
        Node secondNode = first;

        while (secondNode != last && secondNode.next != last){
            firstNode = firstNode.next;
            secondNode = secondNode.next.next;
        }
        if(secondNode.next != null){
            System.out.println(firstNode.value+", "+ firstNode.next.value);
        }
        else {
            System.out.println(firstNode.value);
        }
    }
    public void createWithLoop(){
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        last.next = getPrevious(last);
    }
    public boolean hasLoop(){
        if(isEmpty() || first.next == null){
            return true;
        }
        Node slow = first;
        Node fast = first.next;
        while (fast.next != null && fast != null ){
            if(fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }
}

class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(50);
        System.out.println(list.indexOf(20));
        System.out.println(list.contains(10));
        System.out.println(list.contains(50));
        System.out.println(list.contains(30));
        System.out.println(list.contains(25));
//        list.removeFirst();
//        list.removeLast();
        System.out.println(list.size());

        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        list.reverse();
        var reverseArray = list.toArray();
        System.out.println(Arrays.toString(reverseArray));
        System.out.println(list.getKthNodeFromTheEnd(4));
        list.printMiddle();
        System.out.println(list.hasLoop());
        list.createWithLoop();
        System.out.println(list.hasLoop());
    }
}
