package binary_tree;

import java.util.ArrayList;

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
        System.out.println();

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
        System.out.println();

        System.out.println("Validate BST");
        System.out.println(tree.isBinarySearchTree());
        System.out.println();
//        tree.swap();
//        System.out.println(tree.isBinarySearchTree());
//        System.out.println();

        System.out.println("Node at K distance");
        tree.printNodeAtDistance(2);
        System.out.println();

        System.out.println("Get nodes");
        var list = tree2.getNodesAtDistance(1);
        for(int item : list)
            System.out.println(item);
        System.out.println();


        System.out.println("Level Order BFS traverse");
        tree.traverseLevelOrder();
        System.out.println();

        System.out.println("Tree size");
        System.out.println(tree.size());
        System.out.println();

        System.out.println("Count Leaves");
        System.out.println(tree.countLeaves());
        System.out.println();

        System.out.println("Binary Search Tree Max value");
        System.out.println(tree.binarySearchTreeMax());
        System.out.println();


        System.out.println("Contains");
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(80));
        System.out.println();


        System.out.println("Are siblings");
        System.out.println(tree.areSibling(1, 6));
        System.out.println(tree.areSibling(1, 8));
        System.out.println();


        System.out.println("Get ancestors");
        System.out.println(tree.getAncestors(1));
        System.out.println(tree.getAncestors(10));
        System.out.println(tree.getAncestors(7));
        System.out.println(tree.getAncestors(9));
        System.out.println();


    }
}
