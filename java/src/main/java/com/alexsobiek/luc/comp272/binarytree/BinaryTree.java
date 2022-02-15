package com.alexsobiek.luc.comp272.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryNode<T> root;
    private int size;

    public BinaryTree() {
    }

    public BinaryTree(T value) {
        root = new BinaryNode<>(value);
        size = 1;
    }

    protected BinaryTree(BinaryNode<T> root) {
        this.root = root;
        size = toList().size();
    }

    public void add(T value) {
        BinaryNode<T> node = new BinaryNode<>(value);
        if (root == null) {
            root = node;
            size = 1;
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

    public BinaryNode<T> root() {
        return root;
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

    public List<T> toList() {
        ArrayList<T> list = new ArrayList<>();
        constructListRecursive(list, root);
        return list;
    }

    private void constructListRecursive(List<T> list, BinaryNode<T> node) {
        if (node != null) {
            if (node.left() != null) constructListRecursive(list, node.left());
            list.add(node.value());
            if (node.right() != null) constructListRecursive(list, node.right());
        }
    }

    public String inOrder() {
        return toList().stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    public void replaceValue(T oldValue, T newValue) {
        BinaryNode<T> node = get(oldValue);
        if (node != null) node.value(newValue);
    }

    public int size() {
        return size;
    }
}
