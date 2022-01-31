package com.alexsobiek.luc.comp272.stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Alex Sobiek
 * Loyola University Chicago
 * COMP 272
 * Professor Silva
 */
public class StackExercise {
    public static void main(String[] args) {
        new StackExercise(); // Escape static
    }

    public StackExercise() {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        System.out.printf("Original: %s\n", intStack);
        System.out.printf("Smallest: %d\n", smallestInt(intStack));
        System.out.printf("Reversed: %s\n", reverse(intStack));
        System.out.printf("Insertion: %s\n", insert(clone(intStack), 3, 100));
    }

    /**
     * Clones a stack
     * @param stack Stack to clone
     * @param <T> Type of stack
     * @return Stack
     */
    @SuppressWarnings("unchecked")
    public <T> Stack<T> clone(Stack<T> stack) {
        return (Stack<T>) stack.clone();
    }

    /**
     * Reverses a stack
     * @param stack Stack to reverse
     * @param <T> Type of stack
     * @return Reversed Stack
     */
    public <T> Stack<T> reverse(Stack<T> stack) {
        stack = clone(stack);
        Queue<T> revQueue = new LinkedList<>();
        while(!stack.empty()) revQueue.add(stack.pop());
        Stack<T> reversed = new Stack<>();
        revQueue.forEach(reversed::push);
        return reversed;
    }

    /**
     * Inserts an element at a position in the stack
     * @param stack Stack to insert element into
     * @param position Position to insert at
     * @param element Element to insert
     * @param <T> Type of stack
     * @return Stack
     */
    public <T> Stack<T> insert(Stack<T> stack, int position, T element) {
        Stack<T> out = new Stack<>();
        int i = 0;
        while(!stack.empty()) {
            if (i == position) out.push(element);
            else out.push(stack.pop());
            i++;
        }
        return out;
    }

    /**
     * Returns the smallest Integer in an Integer Stack
     * @param stack Integer Stack
     * @return Integer
     */
    public int smallestInt(Stack<Integer> stack) {
        return stack.stream().min(Integer::compare).orElseThrow();
    }
}
