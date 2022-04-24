package com.alexsobiek.luc.comp272.graphing;

import java.util.*;

public class Graph {
    int numVertices;
    LinkedList<Integer>[] adjListArr;

    public Graph(int numV) {
        numVertices = numV;
        adjListArr = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjListArr[i] = new LinkedList<>();
        }
    }

    public void addEdge(Graph graph, int src, int dest) {
        adjListArr[src].add(dest);
    }

    public void printGraph(Graph graph) {
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Adjaceny list of vertex: " + i);
            System.out.print("Head");
            for (Integer edge : adjListArr[i]) {
                System.out.print(" -> " + edge);
            }
            System.out.println();
        }
    }

    public void BFS(int src) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (queue.size() > 0) {
            src = queue.poll();
            System.out.print(src + " ");
            Iterator<Integer> itr = adjListArr[src].listIterator();

            while (itr.hasNext()) {
                int n = itr.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }



    public List<Integer> vertices(int index) {
        boolean[] visited = new boolean[numVertices];
        List<Integer> vertices = new ArrayList<>();
        vertices(index, vertices, visited);
        return vertices;
    }

    public void vertices(int index, List<Integer> vertices, boolean[] visited) {
        visited[index] = true;
        vertices.add(index);
        for (int n : adjListArr[index]) if (!visited[n]) vertices(n, vertices, visited);
    }

    public double average(int index) {
        double total = 0;
        List<Integer> vertices = vertices(index);
        for (int i : vertices) total += i;
        return total / vertices.size();
    }


    public int getNumVertices() {
        return numVertices;
    }

    public LinkedList<Integer>[] getAdjListArr() {
        return adjListArr;
    }

    public Iterator<BFSGraphEntry> iterator(int src) {
        return new BFSGraphIterator(this, src);
    }
}
