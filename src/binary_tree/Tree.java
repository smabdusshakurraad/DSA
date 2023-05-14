package binary_tree;

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

        if(isLeaf())
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
        if(isLeaf())
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

    private boolean isLeaf(){
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
}
