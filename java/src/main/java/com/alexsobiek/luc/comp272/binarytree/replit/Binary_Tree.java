package com.alexsobiek.luc.comp272.binarytree.replit;

/*
Implement the following functions: inOrder(), insert(), replaceNode(), deleteNode(), and maximumValue()
*/

public class Binary_Tree {
    Node node;

    public Binary_Tree() {
    }

    public String inOrder() {
        StringBuilder builder = new StringBuilder();
        Node node = this.node;
        // left node is always smaller
        while(node.left != null || node.right != null) {
            if (node.left != null) {
                Node current = node.left;

            }
        }


        return builder.toString();
    }

    public int maximumValue() {
        Node current = node;
        while(current.left != null) current = current.left;
        return current.value;
    }
}
