package com.alexsobiek.luc.comp272.linkedlist.replit;

/*
Complete the removeElements method to remove an element from the list. Example: running removeElements(list, 8) would remove all of the 8’s from the list.
 */

class Node {
    int data;
    Node next;
    Node(int d) // Constructor
    {
        data = d;
        next = null;
    }
}

public class LUCLinkedList {// a Singly Linked List
    Node head; // head of list
    public static LUCLinkedList insert(LUCLinkedList list, int data) // Method to insert a new node
    {
        Node new_node = new Node(data); // Create a new node with given data
        new_node.next = null;
        if (list.head == null) { // If the Linked List is empty, then make the new node as head
            list.head = new_node;
        }
        else {// Else traverse till the last node and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node; // Insert the new_node at last node
        }
        return list;
    }

    public static String format(LUCLinkedList list) // Method to output the LinkedList as a String
    {   String output="[";
        Node currNode = list.head;
        //System.out.print("LinkedList: ");
        while (currNode != null) { // Traverse through the LinkedList
            //System.out.print(currNode.data + " "); // Print the data at current node
            output+=currNode.data + " ";
            currNode = currNode.next; // Go to next node
        }
        return output.trim()+"]";
    }
    //remove all the nodes that store a given value (data)
    public static LUCLinkedList removeElements(LUCLinkedList list, int data) {
        Node currentNode = list.head;
        while(currentNode.next != null) {
            if (currentNode.next.data == data) {
                if (currentNode.next.next != null) currentNode.next = currentNode.next.next; // Skip over Node with matching data
                else currentNode.next = null;
            } else currentNode = currentNode.next;
        }
        return list;
    }

    public static void main(String[] args)
    {
        LUCLinkedList list = new LUCLinkedList();/* Start with the empty list. */
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        System.out.println(format(list)); // Print the LinkedList
        removeElements(list, 4);
        System.out.println(format(list)); // Print the LinkedList
    }
}