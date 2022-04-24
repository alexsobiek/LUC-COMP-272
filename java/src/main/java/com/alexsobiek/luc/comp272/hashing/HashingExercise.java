package com.alexsobiek.luc.comp272.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class HashingExercise {
    public static void main(String[] args) {
        new HashingExercise(); // Escape Static
    }

    public HashingExercise() {

        System.out.println(Arrays.toString(positions(new int[]{10, 50, 35, 82, 13})));
        System.out.println();

        printPairs(new int[]{10, 50, 35, 82, 13, 25}, 60);
        printPairs(new int[]{1, 2, 3, 4, 5}, 20);
        System.out.println("\n");

        System.out.println(subset(new int[]{10, 50, 35, 82, 13, 25}, new int[]{10, 35, 13}));
        System.out.println(subset(new int[]{10, 50, 35, 82, 13, 25}, new int[]{10, 35, 13, 8}));
        System.out.println();

        HashMap<String, String> itinerary = new HashMap<>();
        itinerary.put("Chennai", "Banglore");
        itinerary.put("Bombay", "Delhi");
        itinerary.put("Goa", "Chennai");
        itinerary.put("Delhi", "Goa");
        printItinerary(itinerary);
    }

    public int[] positions(int[] array) {
        List<Integer> sorted = Arrays.stream(array).boxed().sorted().toList();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) result[i] = sorted.indexOf(array[i]);
        return result;
    }

    public void printPairs(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(array).parallel().forEach(i -> {
            Arrays.stream(array).parallel().forEach(j -> {
                if (i + j == sum) {
                    if (!map.containsKey(j)) {
                        map.put(i, j); // Prevents printing out duplicates
                        System.out.printf("(%d, %d) ", i, j);
                    }
                }
            });
        });
    }

    public boolean subset(int[] array1, int[] array2) {
        HashSet<Integer> set = Arrays.stream(array1).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int i : array2) if (!set.contains(i)) return false;
        return true;
    }

    public void printItinerary(HashMap<String, String> map) {
        String starting = null;
        for (String key : map.keySet()) {
            if (!map.containsValue(key)) {
                starting = key;
                break;
            }
        }
        if (starting != null) {
            String next = map.get(starting);
            while (next != null) {
                System.out.printf("%s -> %s, ", starting, next);
                starting = next;
                next = map.get(starting);
            }
            System.out.println();
        } else System.out.println("No starting point found");
    }
}
