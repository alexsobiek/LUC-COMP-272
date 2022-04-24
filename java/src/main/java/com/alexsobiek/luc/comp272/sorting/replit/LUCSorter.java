package com.alexsobiek.luc.comp272.sorting.replit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LUCSorter {

    private final int[] a;

    public LUCSorter(int[] anArray) {
        a = anArray;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(checkAscending(new int[]{4, -5, 6, 1, -3, 2, 7, 9, -8, 0}))); // should be -8, -5, -3, 0, 1, 2, 4, 6, 7, 9

        // System.out.println(Arrays.toString(checkEvenOdd(new int[]{2, 5, 6, 4, 6, 9, 2})));

        // System.out.println(Arrays.toString(checkPrimes(new int[]{5, 3, 17, 8, 6, 2, 13, 11, 14, 4})));

        //2, 3, 5, 7, 11, 13, 17, 19, 23 and 29

        System.out.println(Arrays.toString(checkPrimes(new int[]{8, 29, 6, 7, 2, 23}))); // should be 29, 7, 2, 23, 8, 6
    }

    //Check code using this method
    public static int[] checkAscending(int[] values) {
        LUCSorter sorter = new LUCSorter(values);
        sorter.ascending();
        return values;
    }

    public static int[] checkEvenOdd(int[] values) {
        LUCSorter sorter = new LUCSorter(values);
        sorter.evenOdd();
        return values;
    }

    public static int[] checkPrimes(int[] values) {
        LUCSorter sorter = new LUCSorter(values);
        sorter.primeFirst();
        return values;
    }

    /*
    Swap the largest element in the array and position it at the end, and then continue with the next largest element
    Ex. Input: [4, -5, 6, 1, -3, 2, 7, 9, -8, 0]. Output: [-8, -5, -3, 0, 1, 2, 4, 6, 7, 9]

     */

    public void evenOdd() {
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                for (int j = i; j < a.length - 1; j++) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /*
    Starting array: [5, -5, 1, -9, 10, 2, 7, -3]

    10 <-> -3
    [5, -5, 1, -9, -3, 2, 7, 10]

     */
    public void ascending() {
        for (int i = 0; i < a.length; i++) {
            int maxPos = maximumPosition(i);
            swap(maxPos, i); // swap maxPos and i
        }
    }

    //added code in the maximum position
    private int maximumPosition(int to) {
        int pos = to;
        for (int i = to; i < a.length; i++) if (a[i] < a[pos]) pos = i;
        return pos;
    }

    /*
    [5, 3, 17, 8, 6], [2, 13, 11, 14, 4]. Output: [5, 3, 17, 2, 13, 11, 8, 6, 14, 4]
    must be O(n)
     */
    public void merge(int[] first, int[] second) {
    int max = Math.max(Arrays.stream(first).max().orElseThrow(), Arrays.stream(second).max().orElseThrow());

    // Find all primes from 2...max
    // Prime Sieve (Eratosthenes)

    boolean[] primes = new boolean[max + 1];
    Arrays.fill(primes, true);

    // both 0 and 1 are not prime
    primes[0] = false;
    primes[1] = false;

    // Find primes
    for (int i = 2; i * i <= max; i++) {
        if (primes[i]) {
            for (int j = i * 2; j <= max; j += i) {
                primes[j] = false;
            }
        }
    }

        Queue<Integer> nonPrimes = new LinkedList<>();

        int index = 0;

        for (int n : first) {
            if (primes[n]) {            // Add all primes from the first array to a
                a[index] = n;
                index++;
            } else nonPrimes.add(n);    // Save all non-primes from the second array
        }

        for (int n : second) {
            if (primes[n]) {            // Add all primes from the second array to a
                a[index] = n;
                index++;
            } else nonPrimes.add(n);    // Save all non-primes from the second array
        }

        // Add remaining non-primes to the end of a
        while (nonPrimes.peek() != null) {
            a[index] = nonPrimes.poll();
            index++;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1 || num % 2 == 0) return false;
        int bound = (int) Math.floor(Math.sqrt(num));
        for (int i = 3; i <= bound; i += 2) if (num % i == 0) return false;
        return true;
    }

    public void primeFirst() {
        if (a.length <= 1) return;
        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];
        // Copy the first half of "a" into first, the second half into second
        for (int i = 0; i < first.length; i++) first[i] = a[i];
        for (int i = 0; i < second.length; i++) second[i] = a[first.length + i];
        LUCSorter firstSorter = new LUCSorter(first);
        LUCSorter secondSorter = new LUCSorter(second);
        firstSorter.primeFirst();
        secondSorter.primeFirst();
        merge(first, second);
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
