package com.alexsobiek.luc.comp272.stacks.replit;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(StackCode.isPalindrome("abcba")); // true
        System.out.println(StackCode.isPalindrome("abcde")); // false

        Stack<Integer> intStack = new Stack<>();
        intStack.add(10);
        intStack.add(2);
        intStack.add(2);
        intStack.add(3);
        intStack.add(12);
        intStack.add(2);

        System.out.println(StackCode.smallestIndex(intStack, 2)); // 1;
    }
}
