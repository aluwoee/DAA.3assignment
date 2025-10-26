package algos;

import data.Edge;
import data.Graph;
import data.ResultsMst;

import java.util.*;

public class PrimAlgorithm {

    public static ResultsMst findMST(Graph graph) {
        long startTime = System.nanoTime();

        int n = graph.getVertices();
        boolean[] used = new boolean[n];
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        used[0] = true;


        for (Edge e : graph.getEdges()) {
            if (e.src == 0 || e.dest == 0) pq.offer(e);
        }

        while (!pq.isEmpty() && mstEdges.size() < n - 1) {
            Edge current = pq.poll();
            int next = used[current.src] ? current.dest : current.src;

            if (!used[next]) {
                used[next] = true;
                mstEdges.add(current);
                totalCost += current.weight;

                for (Edge e : graph.getEdges()) {
                    if ((e.src == next && !used[e.dest]) || (e.dest == next && !used[e.src])) {
                        pq.offer(e);
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        return new ResultsMst("Prim", mstEdges, totalCost, endTime - startTime);
    }
}

