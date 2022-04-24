package com.alexsobiek.luc.comp272.graphing;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraphIterator implements Iterator<BFSGraphEntry> {
    private final Graph graph;

    private int src;
    private final boolean[] visited;
    private final Queue<Integer> queue;

    private Iterator<Integer> itr;

    public BFSGraphIterator(Graph graph, int src) {
        this.graph = graph;
        this.src = src;
        visited = new boolean[graph.getNumVertices()];
        queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
    }


    @Override
    public boolean hasNext() {
        if ((itr == null || !itr.hasNext()) && queue.size() > 0) {
            src = queue.poll();
            itr = graph.getAdjListArr()[src].listIterator();
            return itr.hasNext();
        } return false;
    }

    @Override
    public BFSGraphEntry next() {
        hasNext();
        int n = itr.next();
        boolean v = visited[n];
        if (!v) {
            visited[n] = true;
            queue.add(n);
        }
        return new BFSGraphEntry(n, v);
    }
}

class BFSGraphEntry {
    private final int vertex;
    private boolean visited;

    public BFSGraphEntry(int vertex, boolean visited) {
        this.vertex = vertex;
        this.visited = visited;
    }

    public int getVertex() {
        return vertex;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean bool) {
        visited = bool;
    }
}
