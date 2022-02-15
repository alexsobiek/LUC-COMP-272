package com.alexsobiek.luc.comp272.binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(2);
        tree.add(5);
        tree.add(3);
        tree.add(4);

        System.out.println(tree.inOrder());

        tree.replaceValue(3, 8);
        System.out.println(tree.toList());
    }
}
