package com.alexsobiek.luc.comp272.graphing.replit;

import com.alexsobiek.luc.comp272.graphing.Graph;

public class GraphingMain {
    public static void main(String[] args) {
        GraphingMain main = new GraphingMain();
        main.testA();
    }

    public void testA() {
        Graph graph = new Graph(5);
        graph.addEdge(graph, 0, 2);
        graph.addEdge(graph, 4, 0);
        graph.addEdge(graph, 2, 1);
        graph.addEdge(graph, 3, 2);
        graph.addEdge(graph, 4, 3);
        graph.addEdge(graph, 3, 1);
        graph.addEdge(graph, 4, 1);
        graph.printGraph(graph);
        graph.BFS(4);


        // System.out.println(graph.sum(4));
        System.out.println(graph.average(4));

        System.out.println(graph.vertices(4));

    }
}
