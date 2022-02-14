package com.alexsobiek.luc.comp272.binarytree;

public class BinaryNode<T extends Comparable<T>> {
    private T value;
    private int count;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode() {
        count = 1;
    }

    public BinaryNode(T value) {
        this();
        this.value = value;
    }

    public T value() {
        return value;
    }

    public void value(T value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public BinaryNode<T> left() {
        return left;
    }

    public void left(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> right() {
        return right;
    }

    public void right(BinaryNode<T> right) {
        this.right = right;
    }

    public BinaryNode<T> compare(BinaryNode<T> other) {
        BinaryNode<T> node = null;
        if (this.value.compareTo(other.value()) < 0 && right != null) node = right;
        else if (this.value.compareTo(other.value()) > 0 && left != null) node = left;
        return node;
    }
}
