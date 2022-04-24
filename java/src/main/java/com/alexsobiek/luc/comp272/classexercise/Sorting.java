package com.alexsobiek.luc.comp272.classexercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    private final int[] array;

    public Sorting(int[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        System.out.printf("Unique Numbers: %d\n", testUnique(new int[]{7, 4, 1, 6, 7, 1}));
        System.out.printf("Minimum Difference: %d\n", testMainDiff(new int[]{1, 19, -4, 31, 38, 25, 100}));
    }

    public static int testUnique(int[] array) {
        Sorting sorting = new Sorting(array);
        return sorting.numUnique();
    }

    public static int testMainDiff(int[] array) {
        Sorting sorting = new Sorting(array);
        return sorting.minDiff();
    }

    public int numUnique() {
        List<Integer> sorted = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < sorted.size() - 1; i++) {
            int i1 = sorted.get(i);
            int i2 = sorted.get(i + 1);
            if (i1 == i2) {
                sorted.remove(Integer.valueOf(i1));
                sorted.remove(Integer.valueOf(i2));
            }
        }
        return sorted.size();
    }

    public int minDiff() {
        Arrays.sort(array);
        return Math.abs(array[1] - array[0]);
    }
}
