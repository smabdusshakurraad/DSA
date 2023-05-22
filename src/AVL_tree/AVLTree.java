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

    public void insert(int value){
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        calculateHeight(root);

        return balance(root);
    }

    private void calculateHeight(AVLNode root) {
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private AVLNode balance(AVLNode node){
        if(isLeftHeavy(node)){
            if(balanceFactor(node.rightChild) < 0)
                node.rightChild = leftRotate(node.rightChild);

            node = rightRotate(node);
        }
            System.out.println(root.value + " is left heavy");
        if(isRightHeavy(node)){
            if(balanceFactor(root.rightChild) > 0)
                node.rightChild = rightRotate(node.rightChild);

            node = leftRotate(node);
        }

        return node;
    }
    private AVLNode rightRotate(AVLNode node) {
        AVLNode newNode = node.leftChild;

        node.leftChild = newNode.rightChild;
        newNode.rightChild = node;

        calculateHeight(node);
        calculateHeight(newNode);

        return newNode;
    }

    private AVLNode leftRotate(AVLNode node){
        AVLNode newNode = node.rightChild;

        node.rightChild = newNode.leftChild;
        newNode.leftChild = node;

        calculateHeight(node);
        calculateHeight(newNode);

        return newNode;
    }

    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(AVLNode node){
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }
}
