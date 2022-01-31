package com.alexsobiek.luc.comp272.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LUCLinkedList<Character> list = new LUCLinkedList<>();
        list.add('A').add('B').add('C');
        System.out.println(list);
        System.out.println(list.peek()); // C
        System.out.println(list.remove()); // C, new list [A, B]
        System.out.println(list);
    }
}
