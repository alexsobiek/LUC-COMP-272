package com.alexsobiek.luc.comp272.binarytree.replit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Binary_Search {
    Node node; // the root node

    /**
     * Constructor
     */
    public Binary_Search() {
        this.node = null;
    }

    /**
     * Constructor
     *
     * @param root Root node
     */
    public Binary_Search(Node root) {
        this.node = root;
    }

    /**
     * Inserts a value
     *
     * @param value Integer to insert
     */
    public void insert(int value) {
        insert(this.node, value);
    }

    /**
     * Inserts a value using the provided node as the starting node
     *
     * @param node  Node to insert after
     * @param value Integer to insert
     * @return Node
     */
    public Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            if (this.node == null) this.node = node;
        } else {
            if (value < node.data) node.left = insert(node.left, value);
            else if (value > node.data) node.right = insert(node.right, value);
        }
        return node;
    }

    /**
     * Returns an in order Queue of Nodes
     *
     * @return Queue
     */
    public Queue<Integer> toQueue() {
        return toQueue(node);
    }

    /**
     * Returns an in order Queue of Nodes starting at the provided Node
     *
     * @param root Root node to start at
     * @return Queue
     */
    public Queue<Integer> toQueue(Node root) {
        Queue<Integer> out = new LinkedList<>();
        toQueueRecursive(out, root);
        return out;
    }

    private void toQueueRecursive(Queue<Integer> queue, Node node) {
        if (node != null) {
            if (node.left != null) toQueueRecursive(queue, node.left);
            queue.add(node.data);
            if (node.right != null) toQueueRecursive(queue, node.right);
        }
    }

    /**
     * Returns a String with each value in order
     *
     * @return String
     */
    public String inOrder() {
        return inOrder(node);
    }

    /**
     * Returns a String with each value in order
     *
     * @param node Node to start at
     * @return String
     */
    public String inOrder(Node node) {
        return toQueue(node).stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    /**
     * Returns the smallest value starting at the provided node
     *
     * @param node Node to find smallest value after
     * @return Node containing smallest value
     */
    public Node minimumElement(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * Deletes the provided node
     *
     * @param node  Node to delete value after
     * @param value Value to delete
     */
    public Node deleteNode(Node node, int value) {
        if (node != null) {
            if (value < node.data) node.left = deleteNode(node.left, value);
            else if (value > node.data) node.right = deleteNode(node.right, value);
            else {
                if (node.left == null) node = node.right;
                else if (node.right == null) node = node.left;
                else {
                    node.data = minimumElement(node.right).data;
                    node.right = deleteNode(node.right, node.data);
                }
            }
        }
        return node;
    }
}
