package com.alexsobiek.luc.comp272.classexercise;

/*
Work on the difference method where you calculate the difference between the sum of all nodes present at odd levels
and the sum of all nodes present at even levels.

the answer for the current setup would be -4. This is because:
(1 + 4 + 5 + 6) - (2 + 3 + 7 + 8) = -4
You start off with odd layer 1
then even layer 2,3
then odd again 4,5,6
then even again 7,8

This can be done recursively.
*/

public class TreeReview {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Node root = new Node(1);                // odd
        root.left = new Node(2);                // even
        root.right = new Node(3);               // even
        root.left.left = new Node(4);           // odd
        root.right.left = new Node(5);          // odd
        root.right.right = new Node(6);         // odd
        root.right.left.left = new Node(7);     // even
        root.right.left.right = new Node(8);    // even
        System.out.println(difference(root, 0, 1));
    }

    public static int difference(Node root, int diff, int level) {
        if (root != null) {
            if (level % 2 == 0) { // Even
                diff += difference(root.left, diff, level + 1);
                diff += difference(root.right, diff, level + 1);
            } else { // Odd
                diff -= difference(root.left, diff, level + 1);
                diff -= difference(root.right, diff, level + 1);
            }
            return diff - root.data; //change this
        } else return 0;
    }
}

class Node {
    int data;
    Node left = null;
    Node right = null;

    Node(int data) {
        this.data = data;
    }
}
