package com.alexsobiek.luc.comp272.queues.replit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Priority {
    public static void main(String[] args) {
        Priority main = new Priority();
        main.assignment5();
    }

    public void assignment5() {
        System.out.println(max10());
    }

    public String max10() {
        StringBuilder builder = new StringBuilder();
        try {
            String data = Files.readString(Path.of("data", "assignment5_priorityqueue1_text.txt"));

            PriorityQueue<Integer> queue = Arrays.stream(data.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .limit(10)
                    .collect(Collectors.toCollection(PriorityQueue::new));

            for (int i = 0; i < 10; i++) builder.append(queue.poll()).append(" ");
            builder.delete(builder.length() - 1, builder.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public double average(PriorityQueue<Integer> queue, int k) {
        AtomicInteger sum = new AtomicInteger();
        queue.stream().sorted().limit(k).forEach(sum::addAndGet);
        return (double) sum.get() / k;
    }

}
