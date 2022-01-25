package com.alexsobiek.luc.comp272.linkedlist;

public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private T data;

    /**
     * Constructor
     * @param data Data for this node
     */
    public Node(T data) {
        this.data = data;
        next = null;
    }

    /**
     * Gets the next node
     * @return Node
     */
    public Node<T> next() {
        return next;
    }

    /**
     * Sets the next node
     * @param next Next node
     * @return Node
     */
    public Node<T> next(Node<T> next) {
        this.next = next;
        return next;
    }

    /**
     * Gets the previous node
     * @return Node
     */
    public Node<T> previous() {
        return previous;
    }

    /**
     * Sets the previous node
     * @param previous Previous node
     * @return Node
     */
    public Node<T> previous(Node<T> previous) {
        this.previous = previous;
        return previous;
    }

    /**
     * Gets the data of this node
     * @return T
     */
    public T data() {
        return data;
    }

    /**
     * Sets the data of this node
     * @param data T data
     * @return T
     */
    public T data(T data) {
        this.data = data;
        return data;
    }

}
