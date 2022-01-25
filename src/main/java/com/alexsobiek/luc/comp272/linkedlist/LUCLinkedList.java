package com.alexsobiek.luc.comp272.linkedlist;

public class LUCLinkedList<T> {
    Node<T> head;

    /**
     * Constructor
     */
    public LUCLinkedList() {
    }

    /**
     * Constructor
     * @param head Initial head node
     */
    public LUCLinkedList(Node<T> head) {
        this.head = head;
    }

    private Node<T> last() {
        Node<T> current = head;
        while(current.next() != null) current = current.next();
        return current;
    }

    /**
     * Adds a value to the linked list
     * @param value Value to add
     * @return LUCLinkedList
     */
    public LUCLinkedList<T> add(T value) {
        if (head != null) {
            Node<T> last = last();
            Node<T> newNode = new Node<>(value);
            newNode.previous(last);
            last.next(newNode);
        }
        else head = new Node<>(value);
        return this;
    }

    /**
     * Peeks the last element in the queue
     * @return T
     */
    public T peek() {
        return last().data();
    }

    /**
     * Removes and returns the last element in the queue
     * @return T
     */
    public T remove() {
        Node<T> last = last();
        if (last.previous() != null) last.previous().next(null);
        return last.data();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<T> current = head;
        while(current.next() != null) {
            builder.append(current.data()).append(", ");
            current = current.next();
        }
        builder.append(current.data()).append("]");
        return builder.toString();
    }

}



