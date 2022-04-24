package com.alexsobiek.luc.comp272.graphing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphingExercise {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 4, 0);
        graph.addEdge(graph, 2, 1);
        graph.addEdge(graph, 3, 2);
        graph.addEdge(graph, 4, 3);
        graph.addEdge(graph, 3, 1);
        graph.addEdge(graph, 4, 1);
        graph.addEdge(graph, 2, 0);
        graph.addEdge(graph, 5, 4);

        System.out.printf("Has path from 0 to 2: %b\n", hasPath(graph, 0, 2));
        System.out.printf("Has path from 0 to 1: %b\n", hasPath(graph, 0, 1));
        System.out.printf("Has path from 0 to 4: %b\n", hasPath(graph, 0, 4));
        System.out.printf("Has path from 0 to 2: %b\n", hasPath2(graph, 0, 2));
        System.out.printf("Has path from 0 to 1: %b\n", hasPath2(graph, 0, 1));
        System.out.printf("Has path from 0 to 4: %b\n", hasPath2(graph, 0, 4));

        System.out.printf("Has cycle from 0: %b\n", hasCycle(graph, 0));
        System.out.printf("Has cycle from 0: %b\n", hasCycle2(graph, 0));

        //System.out.printf("Has cycle from 1: %b\n", hasCycle(graph, 1));
        //System.out.printf("Has cycle from 1: %b\n", hasCycle2(graph, 1));
    }

    public static boolean hasPath(Graph graph, int src, int dest) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (queue.size() > 0) {
            src = queue.poll();
            for (int n : graph.getAdjListArr()[src]) {
                if (!visited[n]) {
                    if (n == dest) return true;
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static boolean hasPath2(Graph graph, int src, int dest) {
        Iterator<BFSGraphEntry> itr = graph.iterator(src);
        while (itr.hasNext()) {
            BFSGraphEntry entry = itr.next();
            if (!entry.isVisited() && entry.getVertex() == dest) return true;
        }
        return false;
    }


    public static boolean hasCycle(Graph graph, int src) {
        boolean[] visited = new boolean[graph.getNumVertices()];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (queue.size() > 0) {
            src = queue.poll();
            for (int n : graph.getAdjListArr()[src]) {
                System.out.println(n);
                if (visited[n]) return true; // If we've already visited this node, there is a cycle
                else {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static boolean hasCycle2(Graph graph, int src) {
        Iterator<BFSGraphEntry> itr = graph.iterator(src);
        while (itr.hasNext()) {
            BFSGraphEntry entry = itr.next();
            System.out.println(entry.getVertex());
            if (entry.isVisited()) return true;
        }
        return false;
    }
}
