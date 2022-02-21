package com.alexsobiek.luc.comp272.treemap.replit;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TreeMap<Integer, String> Age = new TreeMap<>();
        Age.put(10, "James");
        Age.put(13, "Tony");
        Age.put(15, "James");
        Age.put(16, "James");
        Age.put(17, "James");
        // Extra code for testing:
        System.out.println(Age);
        TreeMap<Integer, String> evens = remove_odd(Age);
        System.out.println(evens);
    }

    //Add your code here...
    @SuppressWarnings("unchecked")
    public static TreeMap<Integer, String> remove_odd(TreeMap<Integer, String> treeMap) {
        TreeMap<Integer, String> out = (TreeMap<Integer, String>) treeMap.clone();
        for (Integer key: treeMap.keySet()) {
            if (key %2 == 1) out.remove(key);
        }
        return out;
    }
}
