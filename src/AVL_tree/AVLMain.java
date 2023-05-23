package AVL_tree;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);

        System.out.println();

        System.out.println("Tree is Balanced: " + avlTree.isBalance());;

        System.out.println("Tree is perfect: " + avlTree.isPerfect());

    }
}
