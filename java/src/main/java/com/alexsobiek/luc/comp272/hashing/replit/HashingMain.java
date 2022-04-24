package com.alexsobiek.luc.comp272.hashing.replit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class HashingMain {
    public static void main(String[] args) {
        HashingMain main = new HashingMain();
        // main.assignment4();
        main.assignment5();
    }

    public void assignment4() {
        // Code for testing
        HashMap<Integer, String> hash_map = new HashMap<>();
        hash_map.put(1, "John");
        hash_map.put(2, "Doe");
        hash_map.put(3, "James");
        hash_map.put(4, "Eric");
        System.out.println(even(hash_map));

        HashMap<Integer, Integer> hash_map2 = new HashMap<>();
        hash_map2.put(1, 30);
        hash_map2.put(2, 40);
        hash_map2.put(3, 50);
        hash_map2.put(4, 60);
        System.out.println(average(hash_map2));
    }

    public ArrayList<String> even(HashMap<Integer, String> hashmap) {
        return hashmap.entrySet().stream().filter(s -> s.getKey() % 2 == 0).map(Map.Entry::getValue).sorted().collect(Collectors.toCollection(ArrayList::new));

        /* Non Java Stream version:
        ArrayList<String> evens = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : hashmap.entrySet()) {
            if (entry.getKey() % 2 == 0) evens.add(entry.getValue());
        }
        return evens;
        */
    }

    public double average(HashMap<Integer, Integer> hashmap) {
        return hashmap.values().stream().mapToInt(Integer::intValue).summaryStatistics().getAverage();

        /* Non Java Stream version:
        int sum = 0;
        for (int i : hashmap.values()) sum += i;
        return (double) sum / hashmap.size();
        */
    }

    public void assignment5() {
        Hashtable<String, String> input = new Hashtable<>();
        input.put("Chennai", "Banglore");
        input.put("Bombay", "Delhi");
        input.put("Goa", "Chennai");
        input.put("Delhi", "Goa");
        System.out.println(getItinerary(input));

        System.out.println(exists("COMP XFVG CCCC Test"));
    }

    public String getItinerary(Hashtable<String, String> table) {
        StringBuilder builder = new StringBuilder();

        // Find the starting point
        String start = null;
        for (String key : table.keySet()) {
            if (!table.contains(key)) {
                start = key;
                break;
            }
        }

        // Create the itinerary
        if (start != null) {
            String next = start;
            String prev = start;
            while (next != null) {
                if (!prev.equals(next)) {
                    builder.append(prev).append("->");
                    builder.append(next).append(", ");
                }
                prev = next;
                next = table.get(next);
            }
            builder.delete(builder.length() - 2, builder.length()); // Remove last comma and space
        } else builder.append("No route.");

        return builder.toString();
    }

    public String exists(String string) {
        StringBuilder builder = new StringBuilder();
        try {
            HashSet<String> dictionary = new HashSet<>(
                    Arrays.asList(
                            Files.readString(Path.of("data", "assignment5_hashing2_text.txt"))
                                    .toUpperCase().split("\\s+")
                    )
            );

            String[] parts = string.toUpperCase().split("\\s+");
            for (String s : parts) {
                if (dictionary.contains(s)) builder.append("T ");
                else builder.append("F ");
            }
            builder.delete(builder.length() - 1, builder.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}
