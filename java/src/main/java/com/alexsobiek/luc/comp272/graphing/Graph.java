package com.alexsobiek.luc.comp272.graphing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Graph<T> {
    private final HashMap<T, List<T>> edges;

    public Graph() {
        edges = new HashMap<>();
    }

    public void addEdge(T source, T destination) {
        if (edges.containsKey(source)) edges.get(source).add(destination);
        else edges.put(source, new ArrayList<>(List.of(destination)));
    }

    public void DFS(T source, BiConsumer<Boolean, GraphConsumerTask<T>> consumer) {
        List<T> discovered = new ArrayList<>();
        DFS(source, discovered, consumer);
    }

    public void DFS(T source, List<T> discovered, BiConsumer<Boolean, GraphConsumerTask<T>> consumer) {
        if (edges.containsKey(source)) {
            edges.get(source).forEach(e -> {
                GraphConsumerTask<T> future = new GraphConsumerTask<>(e);
                if (!discovered.contains(e)) {
                    consumer.accept(false, future);
                    if (!future.isExited()) {
                        discovered.add(e);
                        DFS(e, discovered, consumer);
                    }
                } else consumer.accept(true, future);
            });
        } else consumer.accept(false, new GraphConsumerTask<>(source));
    }

    public <E> CompletableFuture<E> completeAsync(Consumer<CompletableFuture<E>> consumer) {
        CompletableFuture<E> future = new CompletableFuture<>();
        new Thread(() -> consumer.accept(future)).start();
        return future;
    }

    public CompletableFuture<Boolean> hasPathDFS(T source, T destination) {
        return completeAsync(future -> {
            DFS(source, (visited, task) -> {
                if (!visited && task.getValue().equals(destination)) {
                    future.complete(true);
                    task.exit(); // We don't need to continue going through the graph, exit
                }
            });
            if (!future.isDone()) future.complete(false);
        });
    }

    public CompletableFuture<Boolean> hasCycle(T source) {
        return completeAsync(future -> {
            DFS(source, (visited, task) -> {
                if (visited) {
                    future.complete(true);
                    task.exit();
                }
            });
            if (!future.isDone()) future.complete(false);
        });
    }

    public CompletableFuture<Optional<T>> findRoot(T source) {
        return completeAsync(future -> {
            List<T> discovered = new ArrayList<>();
            edges.forEach((s, e) -> {
                DFS(s, (visited, task) -> {
                    T val = task.getValue();
                    if (!discovered.contains(val)) {
                        discovered.add(val);
                    }
                });
            });
            future.complete(edges.keySet().stream().filter(e -> !discovered.contains(e)).findFirst());
        });
    }
}

class GraphConsumerTask<T> {
    T value;
    boolean exit;

    public GraphConsumerTask(T value) {
        this.value = value;
    }

    public void exit() {
        exit = true;
    }

    public boolean isExited() {
        return exit;
    }

    public T getValue() {
        return value;
    }
}