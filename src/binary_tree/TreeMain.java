package binary_tree;

public class TreeMain {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        System.out.println(tree.find(10));
        System.out.println();

        System.out.println("Pre Order");
        tree.treePreOrderTraverse();

        System.out.println("In Order");
        tree.inOrderTraverse();
        System.out.println();

        System.out.println("Post Order");
        tree.postOrderTraverse();
        System.out.println();

        System.out.println("Height");
        System.out.println(tree.height());
        System.out.println();

        System.out.println("Min for Binary Search Tree");
        System.out.println(tree.minForBinarySearchTree());
        System.out.println();

        System.out.println("Min for Binary Tree");
        System.out.println(tree.minForBinaryTree());
        System.out.println();

        System.out.println("Equal tree");


        Tree tree2 = new Tree();

        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);

        System.out.println(tree.equals(tree2));
    }
}
