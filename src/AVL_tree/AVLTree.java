package AVL_tree;

public class AVLTree {
    private class AVLNode{
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value){
            this.value = value;
        }

        public String toString(){
            return "Value=" + this.value;
        }
    }

    private AVLNode root;

    /**
     * To initiate recursive call for insert a new node in AVL
     * @param value {@link Integer}
     */
    public void insert(int value){
        root = insert(root, value);
    }

    /**
     * Insert a new node in the subtree of given root
     * return the new root
     * @param root {@link  AVLNode}
     * @param value {@link Integer}
     * @return {@link AVLNode}
     */
    private AVLNode insert(AVLNode root, int value) {
        if (root == null) // return new node if the root is null
            return new AVLNode(value);

        if (value < root.value) // if value less than set the left child
            root.leftChild = insert(root.leftChild, value);
        else // if the value is greater than root set the right subtree
            root.rightChild = insert(root.rightChild, value);

        // calculate the height of each node after insertion
        calculateHeight(root);

        //return the root after balancing the tree
        return balance(root);
    }

    /**
     *  Calculate height of the given node
     * @param root {@link AVLNode}
     */
    private void calculateHeight(AVLNode root) {
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    /**
     * Balance the given node tree and return the new root after balancing
     * @param node {@link AVLNode}
     * @return {@link AVLNode}
     */
    private AVLNode balance(AVLNode node){
        if(isLeftHeavy(node)){ // if left heavy
            // balance factor of left child is greater than 0 means this left subtree only have a right child
            if(balanceFactor(node.leftChild) < 0)
                node.rightChild = leftRotate(node.leftChild); // left rotate lef child

            node = rightRotate(node); // right rotate node
        }
        // if right heavy
        if(isRightHeavy(node)){
            // If right child balance factor is greater than 0 means it only have left subtree
            if(balanceFactor(root.rightChild) > 0)
                node.rightChild = rightRotate(node.rightChild); // right rotate child

            node = leftRotate(node); // left rotate node
        }

        return node; // return balanced node
    }
    private AVLNode rightRotate(AVLNode node) {
        AVLNode newNode = node.leftChild;

        node.leftChild = newNode.rightChild;
        newNode.rightChild = node;

        calculateHeight(node);
        calculateHeight(newNode);

        return newNode;
    }

    /**
     * Left rotate a given node
     * @param node {@link AVLNode}
     * @return {@link AVLNode}
     */
    private AVLNode leftRotate(AVLNode node){
        // create new node with right child
        AVLNode newNode = node.rightChild;

        // exchange new node left child to it's new child's right node
        node.rightChild = newNode.leftChild;
        newNode.leftChild = node;

        // calculate new heights
        calculateHeight(node);
        calculateHeight(newNode);

        return newNode;
    }

    /**
     * return height of a given node
     * @param node {@link AVLNode}
     * @return {@link Integer}
     */
    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }

    /**
     * Return the node is left heavy or not
     * @param node {@link AVLNode}
     * @return {@link Boolean}
     */
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1; // if the balance factor is greater than 1 mean's left heavy
    }
    /**
     * Return the node is left heavy or not
     * @param node {@link AVLNode}
     * @return {@link Boolean}
     */
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1; // if the balance factor is less than -1
    }

    /**
     * Return the balance factor
     * @param node {@link  AVLNode}
     * @return {@link Integer}
     */
    private int balanceFactor(AVLNode node){
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    /**
     * Initiate recursive call for checking balance of the tree
     * @return {@link Boolean}
     */
    public boolean isBalance(){
        return isBalance(root);
    }

    /**
     * Check if the given node is balance
     * @param node {@link AVLNode}
     * @return {@link Boolean}
     */
    private boolean isBalance(AVLNode node){
        if(node == null)
            return true;

        int balanceFactor = balanceFactor(node);
        return (Math.abs(balanceFactor) <= 1) &&  isBalance(node.leftChild)
                && isBalance(node.rightChild);
    }

    /**
     * Check if the tree is perfect, size = 2^height + 1
     * @return {@link Boolean}
     */
    public boolean isPerfect(){
        return isPerfect(root);
    }

    /**
     * Check if the tree from given node is perfect
     * @param root {@link AVLNode}
     * @return {@link Boolean}
     */
    private boolean isPerfect(AVLNode root){
        return size(root) == Math.pow(2, height(root)) + 1;
    }

    /**
     * Size of tree in given node
     * @param node {@link AVLNode}
     * @return {@link Integer}
     */
    private int size(AVLNode node){
        if(node == null)
            return 0;

        return size(node.leftChild) + size(node.rightChild) + 1;
    }
}
