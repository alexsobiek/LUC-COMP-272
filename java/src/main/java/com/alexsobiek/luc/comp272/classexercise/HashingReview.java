package com.alexsobiek.luc.comp272.classexercise;

import java.util.Arrays;
import java.util.HashMap;

public class HashingReview {
    public static void main(String[] args) {
        duplicateTest();
    }

    /*
    For this method, you will organize the nums array based on the positions array. All of the numbers in the nums
    array will be positioned using the pos array. This will be done using hashmaps. for example, nums = [1,2,3] and
    pos = [1,2,0], the result will be [3,1,2]
    */
    public static void shuffleTest() {
        System.out.println("Hello world!");
        int[] nums = {1, 2, 3, 4, 5};        // input array
        int[] pos = {3, 2, 4, 1, 0};        // position array
        //output will be: [5, 4, 2, 1, 3]
        shuffle(nums, pos);
        System.out.println(Arrays.toString(nums));
    }

    /*
    the goal of this method is to see if there are duplicate numbers in a range of "k". For the array of [1,2,3,2]
    and k of 1, there will be no duplicates since the numbers next to the first 2 are 1(before) and 3(after).
    However, if k is changed to 2, then there are duplicates found. You will be using a hashmap to store the values
    and check the values.
    */
    public static void duplicateTest() {
        System.out.println("Hello world!");
        int[] nums = {1, 2, 3, 1, 2};
        int k = 2;
        //5, 6, 8, 2, 4, 6, 9
        if (hasDuplicate(nums, k)) {
            System.out.println("Duplicates found");
        } else {
            System.out.println("No duplicates were found");
        }
    }

    public static boolean hasDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) return true;
            else map.put(nums[i], i);
        }
        return false;
    }

    public static void shuffle(int[] nums, int[] pos) {


    }
}
