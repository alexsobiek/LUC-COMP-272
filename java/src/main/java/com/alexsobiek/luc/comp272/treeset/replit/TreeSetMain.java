package com.alexsobiek.luc.comp272.treeset.replit;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Set<Integer> ts1 = new TreeSet<>();
        ts1.add(9);
        ts1.add(7);
        ts1.add(6);
        Set<Integer> ts2 = new TreeSet<>();
        ts2.add(4);
        ts2.add(5);
        ts2.add(6);

        //Extra code for testing:
        System.out.println(ts2);
        System.out.println(ts1);
        System.out.println(similar(ts1, ts2));

    }

    //Add your code here...
    public static Set<Integer> similar(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> inBothSets = new TreeSet<>();
        for (int numInSet1 : set1)
            if (set2.contains(numInSet1)) {
                // the add function only adds the element if it is not already in the set, so this condition is true when the element already exists
                inBothSets.add(numInSet1);
            }
        return inBothSets;
    }
}
