package com.alexsobiek.luc.comp272.graphing.replit;

import java.util.ArrayList;
import java.util.List;

public class GraphB {
    List<List<Integer>> adjList;

    GraphB(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }

    //auxiliary method
    public static void DFS(GraphB graph, int v, boolean[] discovered) {
        discovered[v] = true;
        for (int u : graph.adjList.get(v)) {
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }

    public static int find_root(GraphB graph, int index) {

        return -1; // temp
    }
}

class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}