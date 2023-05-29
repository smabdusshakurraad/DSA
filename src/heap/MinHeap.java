package heap;

public class MinHeap {
    private class Node{
        private int key;
        private String value;

        public Node(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] items = new Node[10];
    private int size;

    public void insert(int key, String value){
        if(isFull())
            throw new IllegalStateException();

        Node node = new Node(key, value);
        items[size++] = node;

        if(size > 0){
            bubbleUp();
        }

    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();

        var removedKey = items[0].key;
        items[0] = items[--size];
        bubbleDown();

        return removedKey;
    }

    private void bubbleDown() {
        int currentIndex = 0;

        while (currentIndex < size - 1 && !validParent(currentIndex)){
                var smallerChildIndex = smallerChildIndex(currentIndex);
                swap(items, currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
        }
    }

    private boolean validParent(int currentIndex) {
        if(!hasLeftChild(currentIndex))
            return true;

        var valid = items[currentIndex].key < leftChild(currentIndex).key;

        if(hasRightChild(currentIndex))
            valid &= items[currentIndex].key < rightChild(currentIndex).key;

        return valid;
    }

    private boolean hasRightChild(int parentIndex) {
        return rightChildIndex(parentIndex) <= size;
    }

    private boolean hasLeftChild(int parentIndex) {
        return leftChildIndex(parentIndex) <= size;
    }

    private int smallerChildIndex(int parentIndex) {
        if(leftChild(parentIndex).key < rightChild(parentIndex).key)
            return leftChildIndex(parentIndex);

        return rightChildIndex(parentIndex);
    }

    private Node rightChild(int parentIndex){
        if(rightChildIndex(parentIndex) > items.length)
            throw new IllegalStateException();

        return items[rightChildIndex(parentIndex)];
    }
    private int rightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private Node leftChild(int parentIndex){
        if(leftChildIndex(parentIndex) > items.length)
            throw new IllegalStateException();
        return items[leftChildIndex(parentIndex)];
    }
    private int leftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private void bubbleUp(){
        var currentIndex = size - 1;
        while (currentIndex > 0 && !isValidChild(currentIndex)){
            swap(items, parentIndex(currentIndex), currentIndex);
            currentIndex = parentIndex(currentIndex);
        }
    }

    private boolean isValidChild(int childIndex) {
        if(parentIndex(childIndex) < 0)
            throw new IllegalStateException();
        return items[parentIndex(childIndex)].key < items[childIndex].key;
    }

    private int parentIndex(int currentIndex) {
        return (currentIndex -1) / 2;
    }

    private void swap(Node[] items, int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == items.length;
    }
}
