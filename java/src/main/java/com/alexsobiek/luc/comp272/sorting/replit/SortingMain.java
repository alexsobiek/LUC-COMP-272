package com.alexsobiek.luc.comp272.sorting.replit;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class SortingMain {
    public static void main(String[] args) {
        SortingMain sortingMain = new SortingMain();
        sortingMain.sorting1();
        sortingMain.sorting2();
        sortingMain.sorting3();
    }

    private void sorting1() {
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(20);
        test.add(10);
        test.add(10);
        test.add(60);
        test.add(60);
        test.add(60);

        System.out.println(test);
        System.out.println(showDup(test));
    }

    private void sorting2() {
        List<Student> test = new ArrayList<>();
        test.add(new Student("Tony", 20, 3.5));
        test.add(new Student("James", 23, 4.2));
        test.add(new Student("John", 23, 2.2));
        test.add(new Student("Tom", 22, 4.0));
        System.out.println(stud_sort(test));
    }

    private void sorting3() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        int target = 4;
        System.out.println(pair(nums, target));
    }

    // must be O(n log n)
    public ArrayList<Integer> showDup(ArrayList<Integer> nums) {
        ArrayList<Integer> sorted = (ArrayList<Integer>) nums.clone();
        sorted.sort(Integer::compareTo);
        LinkedHashSet<Integer> duplicates = new LinkedHashSet<>();

        while (sorted.size() > 2) {
            int n = sorted.get(1);
            if (n == sorted.get(2)) {
                duplicates.add(n);
                sorted.remove(sorted.get(2));
            }
            if (n == sorted.get(0)) duplicates.add(n);
            sorted.remove(1);
            sorted.remove(0);
        }

        return new ArrayList<>(duplicates);
    }


    public String stud_sort(List<Student> students) {
        students.sort(Student::compareTo);
        StringBuilder builder = new StringBuilder();
        students.forEach(student -> builder.append(student.getName()).append(", "));
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

    public ArrayList<String> pair(int[] nums, int target) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) result.add(String.format("(%d,%d)", nums[i], nums[j]));
        result.sort(String::compareTo);
        return result;
    }
}
