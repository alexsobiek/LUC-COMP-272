package com.alexsobiek.luc.comp272.stacks.replit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
a. Complete the isPalindrome method to check if the input string by a user is a palindrome (a word that is spelled the
same in reverse as it is spelled straightforward).

b. Complete the smallestIndex method which takes a stack and an integer K as inputs and then returns the smallest
index of K in the stack. Example: Given the stack [5,3,1,4,1[ and K=1, the method will return 2.
 */
public class StackCode {

    public static boolean isPalindrome(String input){
        char[] forwardChars = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : forwardChars) stack.push(c);
        Stack<Character> reversedStack = reverse(stack);
        StringBuilder reversedString = new StringBuilder();
        reversedStack.forEach(reversedString::append);
        return input.equals(reversedString.toString());
    }

    public static int smallestIndex(Stack<Integer> s, int input){
        int smallestIndex = -1;
        int i = 0;

        while(i < s.size() && smallestIndex == -1) {
            if (s.get(i) == input) smallestIndex = i;
            i++;
        }
        return smallestIndex;

    }

    /**
     * Clones a stack
     * @param stack Stack to clone
     * @param <T> Type of stack
     * @return Stack
     */
    @SuppressWarnings("unchecked")
    public static <T> Stack<T> clone(Stack<T> stack) {
        return (Stack<T>) stack.clone();
    }

    /**
     * Reverses a stack
     * @param stack Stack to reverse
     * @param <T> Type of stack
     * @return Reversed Stack
     */
    public static <T> Stack<T> reverse(Stack<T> stack) {
        stack = clone(stack);
        Queue<T> revQueue = new LinkedList<>();
        while(!stack.empty()) revQueue.add(stack.pop());
        Stack<T> reversed = new Stack<>();
        revQueue.forEach(reversed::push);
        return reversed;
    }
}