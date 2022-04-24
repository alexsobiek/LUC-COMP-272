package com.alexsobiek.luc.comp272.classexercise;


import java.util.*;

/*
Your goal is to work on the method transform that replaces the input array with the ranking of each of its elements.
In the array of [7,9,2,10], the ranking would be [2,3,1,4]. Since 2 is the smallest number, it gets the rank of 1 and
then the next biggest 7, gets the rank of 2. I have provided you with a TreeMap to work off of.
*/

public class MapRanking {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] input = {10, 8, 15, 12, 6, 20, 1};        // 1, 6, 8, 10, 12, 15, 20
        //result should be: [4, 3, 6, 5, 2, 7, 1]

        transform(input);
        System.out.println(Arrays.toString(input));
    }


    public static void transform(int[] input) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length; i++) map.put(input[i],i);
        List<Integer> keys = map.keySet().stream().sorted().toList();
        // List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < keys.size(); i++) input[map.get(keys.get(i))] = i+1;
    }
}
