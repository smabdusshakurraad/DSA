package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    /**
     * Nested class for nodes in the tree
     */
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }

        /**
         * Over ride to string method to print node value
         * @return {@link String}
         */
        @Override
        public String toString() {
            return "Node " + this.value;
        }
    }

    // root node of the tree
    private Node root;

    /**
     * Insert a new node in binary search tree | O(logN)
     * @param value {@link Integer}
     */
    public void insert(int value){
        var node = new Node(value);
        if(root == null){
            root = node;
        }else{
            Node current = root;
            while (true){
                // if value is less than the current node value
                if(value < current.value){
                    // if left child of current node is null
                    if(current.leftChild == null){
                        current.leftChild = node;
                        return;
                    }
                    current = current.leftChild;
                }
                // Else if value is greater than or equal to current node value
                else{
                    // if right child of current node is null
                    if(current.rightChild == null){
                        current.rightChild = node;
                        return;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    /**
     * Find a given value node in binary search tree | O(logN)
     * @param value {@link Integer}
     * @return {@link Boolean}
     */
    public boolean find(int value){
        Node current = root; // starting from the root node
        while (current != null){ // while current is not empty
            if(current.value > value){ // if value is less than current node value
                current = current.leftChild; // move to left node
            }
            else if(current.value < value){ // if value is greater than current node value
                current = current.rightChild; // move to right node
            }
            else
                return true; // if value is equal return true
        }

        return false; // if value is not found after traversing the whole tree return false
    }

    /**
     *  This method is to initiate the recursive call for preorder traverse
     */
    public void treePreOrderTraverse(){
        treePreOrderTraverse(root);
    }

    /**
     * Recursive method for preorder traversal
     * @param node {@link Node}
     */
    private void treePreOrderTraverse(Node node){
        if(node == null) // if root is null or tree is empty
            return;

        System.out.println(node.value); // first print root
        treePreOrderTraverse(node.leftChild); // traverse left subtree
        treePreOrderTraverse(node.rightChild); // traverse right subtree
    }

    /**
     *  This method is to initiate the recursive call for inorder traverse
     */
    public void inOrderTraverse(){
        inOrderTraverse(root);
    }

    /**
     * Recursive method for inorder traversal
     * returns ascending order for BST and descending order while traversed right first
     * @param node {@link Node}
     */
    private void inOrderTraverse(Node node){
        if(node == null) // if root is null or empty
            return;
        postOrderTraverse(node.leftChild); // traverse left subtree
        System.out.println(node.value); // print the root value
        postOrderTraverse(node.rightChild); // traverse right subtree
    }

    /**
     * This method is to initiate the recursive call for postorder traversal
     */
    public void postOrderTraverse(){
        postOrderTraverse(root);
    }

    /**
     * Recursive method for postorder traversal
     * @param node {@link Node}
     */
    private void postOrderTraverse(Node node){
        if(node == null)
            return;

        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.value);
    }

    /**
     * Recursive method to return height of a tree from the longest leaf node
     * @return {@link Integer}
     */
    public int height(){
        return height(root);
    }

    /**
     * Recursive method to return height of a node from the longest leaf node, return -1 if tree is empty
     * @param node {@link Node}
     * @return {@link Integer}
     */
    private int height(Node node){
        if(node == null) // if node is null
            return -1;

        if(isLeaf(node)) // if node is a leaf
            return 1;

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    /**
     * This method is to initiate the recursive call for find the min value in BT | O(N)
     * @return {@link Integer}
     */
    public int minForBinaryTree(){
        return minForBinaryTree(root);
    }

    /**
     * Recursive method to find the min value from Binary tree
     * @param node {@link Node}
     * @return {@link Integer}
     */
    private int minForBinaryTree(Node node){
        if(node == null) // if tree is empty
            throw new IllegalStateException("Tree is empty");
        if(isLeaf(node)) // if node is leaf node
            return node.value;

        var left = minForBinaryTree(node.leftChild); // left traverse
        var right = minForBinaryTree(node.rightChild); // right traverse

        return Math.min(Math.min(left, right), node.value); // return the min from left, right or root
    }

    /**
     * Recursive function to find minimum value from a BST
     * @return {@link Integer}
     */
    public int minForBinarySearchTree(){
        if(root == null) // if tree is empty
            throw new IllegalStateException("Tree is Empty");

        Node current = root;
        Node last = current;

        while (current != null){ // while current node is not null
            last = current; // last is current
            current = current.leftChild; // current is moved to left child
        }

        return last.value; // while current is null return previous last node value
    }

    /**
     * Return if the node is a leaf node or not
     * @param node {@link Node}
     * @return {@link Boolean}
     */
    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    /**
     * This method is to initiate the recursive call for the method to check if two trees are equal or not
     * @param other {@link Tree}
     * @return {@link Boolean}
     */
    public boolean equals(Tree other){
        if(other == null) // if the other tree is empty
            return false;
        return equals(this.root, other.root);
    }

    /**
     * Method is to find that two trees are equal or not
     * @param first {@link Node}
     * @param second {@link Node}
     * @return {@link Boolean}
     */
    private boolean equals(Node first, Node second){
        if(first == null && second == null){ // if both of the tree's nodes are equals to null
            return true;
        }

        if(first != null && second != null){ // if both of the tree's nodes are not equals to null
            return first.value == second.value // both of their node value is equal
                    && equals(first.leftChild, second.leftChild) // check for left subtree
                    && equals(first.rightChild, second.rightChild); // check for right subtree
        }
        return false;
    }

    /**
     * This method is to initiate recursive call of the method to find that a tree is BST or not
     * @return {@link Boolean}
     */
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Method to find that if a tree is BST or not
     * @param node {@link Node }
     * @param min {@link Integer}
     * @param max {@link Integer}
     * @return {@link Boolean}
     */
    private boolean isBinarySearchTree(Node node, int min, int max){
        if(node == null) // if node is null
            return true;

        return min < node.value && node.value < max // if the value is greater than min and less than max
                && isBinarySearchTree(node.leftChild, min, node.value) // traverse left subtree with min and node.value
                && isBinarySearchTree(node.rightChild, node.value, max); // traverse right subtree with node.value and max
    }

    /**
     * A method to swap the whole tree
     */
    public void swap(){
        var temp = root.leftChild; // temp equal left child
        root.leftChild = root.rightChild; // left child equals right child
        root.rightChild = temp; // right child equals temp
    }

    /**
     * This method is to initiate the recursive call for the method to find the node at k distance from root
     * @param distance {@link Integer}
     */
    public void printNodeAtDistance(int distance){
        printNodeAtDistance(root, distance);
    }

    /**
     * Recursive method to print the node at K distance from the root
     * @param node {@link Node}
     * @param distance {@link Integer}
     */
    private void printNodeAtDistance(Node node, int distance){
        if(node == null) // if node is null
            return;

        if(distance == 0){ // when distance is zero
            System.out.println(node.value);
            return;
        }

        printNodeAtDistance(node.leftChild, distance-1); // traverse left subtree
        printNodeAtDistance(node.rightChild, distance-1); // traverse right subtree

    }

    /**
     * This method is to initiate the recursive call for the method to get list of nodes at Kth distance
     * @param distance {@link Integer}
     * @return {@link ArrayList<Integer>}
     */
    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);

        return list;
    }

    /**
     * Method to get the list of nodes at Kth distance from a node
     * @param node {@link Node}
     * @param distance {@link Integer}
     * @param list {@link ArrayList<Integer>}
     */
    private void getNodesAtDistance(Node node, int distance, ArrayList<Integer> list){
        if(node == null) // if node is null
            return;

        if(distance == 0){ // if distance is zero
            list.add(node.value);
            return;
        }

        getNodesAtDistance(node.leftChild, distance-1, list); // traverse left subtree
        getNodesAtDistance(node.rightChild, distance-1, list); // traverse right subtree

    }

    /**
     * Level order traversal BFS
     */
    public void traverseLevelOrder(){
        for(int i = 0; i <= height(); i++){
            for(var value : getNodesAtDistance(i)){ // for all the node at i level
                System.out.println(value);
            }
        }
    }

    /**
     * Method to initiate recursive call for the method to get the size(total number of nodes) of three
     * @return {@link Node}
     */
    public int size(){
        return size(root);
    }

    /**
     * Method to get total number of nodes (size) from a given node in a tree
     * @param node {@link Node}
     * @return {@link Integer}
     */
    private int size(Node node){
        if(node == null)
            return 0;

        return 1 + size(node.leftChild) + size(node.rightChild);
    }

    /**
     * Return the Count of the number of leaves from root
     * @return {@link Integer}
     */
    public int countLeaves(){
        return countLeaves(root);
    }

    /**
     *  Count leaves from given node
     * @param node {@link Node}
     * @return {@link Integer}
     */
    private int countLeaves(Node node){
        if(node == null) // if node is null
            return 0;

        if(isLeaf(node)) // if node is a leaf
            return 1;

        return countLeaves(node.leftChild) + countLeaves(node.rightChild); // add count from left subtree and right subtree
    }

    /**
     * Find the Max value of BST from root
     * @return {@link Integer}
     */
    public int binarySearchTreeMax(){
        return binarySearchTreeMax(root);
    }

    /**
     * Find Max from given node of a BST
     * @param node {@link Node}
     * @return {@link Integer}
     */
    private int binarySearchTreeMax(Node node){
        if(node.rightChild == null)
            return root.value;

        return binarySearchTreeMax(root.rightChild);
    }

    /**
     * Return if the tree contains the given node
     * @param item {@link Integer}
     * @return {@link Boolean}
     */
    public boolean contains(int item){
        return contains(root, item);
    }

    /**
     * If the value is the child of the node
     * @param node {@link Node}
     * @param item {@link Integer}
     * @return {@link Boolean}
     */
    private boolean contains(Node node, int item){
        if(node == null) // while root is null or the tree is empty
            return false;

        if(node.value == item) // if value is found
            return true;

        return contains(node.leftChild, item) || contains(node.rightChild, item); // traverse left subtree and right subtree
    }

    /**
     * Find that 2 node are siblings
     * @param value1 {@link Integer}
     * @param value2 {@link Integer}
     * @return {@link Boolean}
     */
    public boolean areSibling(int value1, int value2){
        return areSibling(root, value1, value2);
    }

    /**
     * Are siblings from a given root's subtree
     * @param node {@link Node}
     * @param value1 {@link Integer}
     * @param value2 {@link Integer}
     * @return {@link Boolean}
     */
    private boolean areSibling(Node node, int value1, int value2){
        if(node == null) // while node is null
            return false;

        if(!isLeaf(node)){ // if the node is not a leaf
            if((root.leftChild.value == value1 && root.rightChild.value == value2) || (root.leftChild.value == value2 && root.rightChild.value == value1))
                return true;
        }

        return areSibling(root.leftChild, value1, value2) || areSibling(root.rightChild, value1, value2);
    }

    /**
     * Get ancestors list of a node in a tree
     * @param value {@link Integer}
     * @return {@link List<Integer>}
     */
    public List<Integer> getAncestors(int value){
        List<Integer> ancestors = new ArrayList<>();
        getAncestors(root, value, ancestors);

        return ancestors;
    }

    private boolean getAncestors(Node node, int value, List<Integer> ancestors){
        if(node == null) // if node is null
            return false;
        if(node.value == value) // if the value is found
            return true;

        // if the node contains the value in it's left or right sub tree
        if(getAncestors(node.leftChild, value, ancestors) || getAncestors(node.rightChild, value, ancestors)){
            ancestors.add(node.value);
            return true;
        }

        return false;
    }
}
