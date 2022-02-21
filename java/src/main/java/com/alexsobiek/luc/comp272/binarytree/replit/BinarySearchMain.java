package com.alexsobiek.luc.comp272.binarytree.replit;

public class BinarySearchMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Binary_Search tree = new Binary_Search();
        tree.node = new Node(1);
        tree.node.left = new Node(2);
        tree.node.right = new Node(3);
        tree.node.left.left = new Node(5);
        tree.node.right.right = new Node(10);

        // Eric's test code:
        Binary_Search tree2 = new Binary_Search();
        tree2.node = new Node(5);
        tree2.node.left = new Node(3);
        tree2.node.right = new Node(7);
        tree2.node.left.left = new Node(1);
        tree2.node.right.right = new Node(10);

        System.out.println(tree2.inOrder());
        tree2.deleteNode(tree2.node, 3);
        System.out.println(tree2.inOrder());


        /* Additional test code
        System.out.println(tree.inOrder(tree.node)); //5 2 1 3 10
        tree.insert(tree.node, 6);//inserts 6 where it fits
        System.out.println(tree.inOrder(tree.node)); //5 2 1 3 6 10
        tree.deleteNode(tree.node, 3);
        System.out.println(tree.inOrder(tree.node));//5 2 1 6 10
        System.out.println(tree.minimumElement(tree.node).data); //5
        */
    }
}
