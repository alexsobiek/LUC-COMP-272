package com.alexsobiek.luc.comp272.binarytree;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryNode<T> root;
    private int length;

    public BinaryTree() {
    }

    public BinaryTree(T value) {
        root = new BinaryNode<>(value);
        length = 1;
    }

    public void add(T value) {
        BinaryNode<T> node = new BinaryNode<>(value);
        if (root == null) {
            root = node;
            length = 1;
        }
        else {
            BinaryNode<T> current = root;
            BinaryNode<T> existing = get(node.value()); // Retrieve the node of the value if it already exists
            if (existing != null) existing.addCount(); // Increment the existing node's count if it exists
            else {
                boolean traversing = true;
                while (traversing) {
                    int compareValue = value.compareTo(current.value());
                    if (compareValue < 0) { // left
                        BinaryNode<T> left = current.left();
                        if (left == null) {
                            current.left(node);
                            traversing = false;
                        } else current = left;
                    } else if (compareValue > 0) { // right
                        BinaryNode<T> right = current.right();
                        if (right == null) {
                            current.right(node);
                            traversing = false;
                        } else current = right;
                    }
                    else traversing = false; // values are equal
                }
            }
        }
    }

    public BinaryNode<T> get(T value) {
        boolean contains = false;
        BinaryNode<T> node = new BinaryNode<>(value);
        BinaryNode<T> current = root;
        while (current != null && !contains) {
            contains = current.value().compareTo(node.value()) == 0;
            if (!contains) current = current.compare(node);
        }
        return current;
    }

    public boolean contains(T value) {
        return get(value) != null;
    }
}
