package binary_tree;

import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node " + this.value;
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
        }else{
            Node current = root;
            while (true){
                if(value < current.value){
                    if(current.leftChild == null){
                        current.leftChild = node;
                        return;
                    }
                    current = current.leftChild;
                }else{
                    if(current.rightChild == null){
                        current.rightChild = node;
                        return;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while (current != null){
            if(current.value > value){
                current = current.leftChild;
            }
            else if(current.value < value){
                current = current.rightChild;
            }
            else
                return true;
        }

        return false;
    }


    public void treePreOrderTraverse(){
        treePreOrderTraverse(root);
    }

    private void treePreOrderTraverse(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        treePreOrderTraverse(root.leftChild);
        treePreOrderTraverse(root.rightChild);
    }

    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node root){
        if(root == null)
            return;
        postOrderTraverse(root.leftChild);
        System.out.println(root.value);
        postOrderTraverse(root.rightChild);
    }

    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    private void postOrderTraverse(Node root){
        if(root == null)
            return;

        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 1;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minForBinaryTree(){
        return minForBinaryTree(root);
    }

    // O(n)
    private int minForBinaryTree(Node root){
        if(root == null)
            return Integer.MAX_VALUE;
        if(isLeaf(root))
            return root.value;

        var left = minForBinaryTree(root.leftChild);
        var right = minForBinaryTree(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public int minForBinarySearchTree(){
        if(root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;

        while (current != null){
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    private boolean isLeaf(Node root){
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean equals(Tree other){
        if(other == null)
            return false;
        return equals(this.root, other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null){
            return true;
        }

        if(first != null && second != null){
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        return min < root.value && root.value < max
                && isBinarySearchTree(root.leftChild, min, root.value)
                && isBinarySearchTree(root.rightChild, root.value, max);
    }

    public void swap(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public void printNodeAtDistance(int distance){
        printNodeAtDistance(root, distance);
    }

    private void printNodeAtDistance(Node root, int distance){
        if(root == null)
            return;

        if(distance == 0){
            System.out.println(root.value);
            return;
        }

        printNodeAtDistance(root.leftChild, distance-1);
        printNodeAtDistance(root.rightChild, distance-1);

    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);

        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null)
            return;

        if(distance == 0){
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);

    }


    public void traverseLevelOrder(){
        for(int i = 0; i <= height(); i++){
            for(var value : getNodesAtDistance(i)){
                System.out.println(value);
            }
        }
    }


    public int size(){
        return size(root);
    }

    private int size(Node root){
        if(root == null)
            return 0;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if(root == null)
            return 0;

        if(isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int binarySearchTreeMax(){
        return binarySearchTreeMax(root);
    }

    private int binarySearchTreeMax(Node root){
        if(root.rightChild == null)
            return root.value;

        return binarySearchTreeMax(root.rightChild);
    }

    public boolean contains(int item){
        return contains(root, item);
    }

    private boolean contains(Node root, int item){
        if(root == null)
            return false;

        if(root.value == item)
            return true;

        return contains(root.leftChild, item) || contains(root.rightChild, item);
    }

    public boolean areSibling(int value1, int value2){
        return areSibling(root, value1, value2);
    }

    private boolean areSibling(Node root, int value1, int value2){
        if(root == null)
            return false;

        if(!isLeaf(root)){
            if((root.leftChild.value == value1 && root.rightChild.value == value2) || (root.leftChild.value == value2 && root.rightChild.value == value1))
                return true;
        }

        return areSibling(root.leftChild, value1, value2) || areSibling(root.rightChild, value1, value2);
    }
}
