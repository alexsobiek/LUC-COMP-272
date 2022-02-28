package com.alexsobiek.luc.comp272.hashing.replit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashingMain {
    public static void main(String[] args) {
        new HashingMain().test();
    }

    public void test() {
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
    }

    public double average(HashMap<Integer, Integer> hashmap) {
        return hashmap.values().stream().mapToInt(Integer::intValue).summaryStatistics().getAverage();

        /* Non Java Stream version:
        int sum = 0;
        for (int i : hashmap.values()) sum += i;
        return sum / hashmap.size();
         */
    }
}
