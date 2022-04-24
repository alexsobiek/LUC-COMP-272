package com.alexsobiek.luc.comp272.sorting.replit;

import java.util.Arrays;
import java.util.Comparator;

public class LUCPathCompare implements Comparator<String> {

    public static void main(String[] args) {
        String[] strAr2 = {"/usr/bin/hashcat", "/usr/bin/nmap", "/etc/sudoers", "/etc/shadow"};
        System.out.println(Arrays.toString(sort(strAr2)));
    }

    static String[] sort(String[] paths) {
        Arrays.sort(paths, new LUCPathCompare());
        return paths;
    }

    public int compare(String p1, String p2) {
        int diff = countSlashes(p1) - countSlashes(p2);
        if (diff == 0) return p1.compareTo(p2);  // equal, sort in alphabetical order
        else return diff;
    }

    private int countSlashes(String p) {
        return p.length() - p.replace("/", "").length();
    }
}