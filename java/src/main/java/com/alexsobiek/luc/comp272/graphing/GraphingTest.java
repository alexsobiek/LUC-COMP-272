package com.alexsobiek.luc.comp272.graphing;

import java.util.concurrent.CompletableFuture;

public class GraphingTest {
    public static void main(String[] args) {
        GraphingTest test = new GraphingTest();
        test.testGraph(test.graphA(), "A").thenRun(() -> {
            test.testGraph(test.graphB(), "B").thenRun(() -> {
                test.testGraph(test.graphC(), "C");
            });
        });
    }

    public Graph<Integer> graphA() {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // creates cycle 0 -> 1 -> 2 -> 3 -> 0
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);
        return graph;
    }

    public Graph<Integer> graphB() {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 2);
        graph.addEdge(4, 0);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);
        graph.addEdge(2, 0); // creates cycle 0 -> 2 -> 2 -> 0
        graph.addEdge(5, 4);
        return graph;
    }

    public Graph<Integer> graphC() {
        // This should fail all tests
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);
        return graph;
    }

    public CompletableFuture<Void> testGraph(Graph<Integer> graph, String name) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        System.out.printf("===== Running Tests on Graph %s =====\n", name);
        graph.hasPathDFS(0, 2).thenAccept(path -> {
            System.out.printf("Has path from 0 to 2: %b\n", path);
        }).thenRun(() -> {
            graph.hasPathDFS(0, 1).thenAccept(path -> {
                System.out.printf("Has path from 0 to 1: %b\n", path);
            });
        }).thenRun(() -> {
            graph.hasPathDFS(0, 4).thenAccept(path -> {
                System.out.printf("Has path from 0 to 4: %b\n", path);
            });
        }).thenRun(() -> {
            graph.hasCycle(0).thenAccept(cycle -> {
                System.out.printf("Has cycle from 0: %b\n", cycle);
            });
        }).thenRun(() -> {
            graph.findRoot(0).thenAccept(root -> {
                if (root.isPresent()) System.out.printf("Root from 0: %s\n", root.get());
                else System.out.println("No root from 0");
                future.complete(null);
            });
        });
        return future;
    }
}
