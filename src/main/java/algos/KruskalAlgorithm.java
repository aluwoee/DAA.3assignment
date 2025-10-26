package algos;

import data.Edge;
import data.Graph;
import data.ResultsMst;

import java.util.*;

public class KruskalAlgorithm {

    private static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) parent[ra] = rb;
            else if (rank[ra] > rank[rb]) parent[rb] = ra;
            else {
                parent[rb] = ra;
                rank[ra]++;
            }
        }
    }

    public static ResultsMst findMST(Graph graph) {
        long start = System.nanoTime();

        List<Edge> allEdges = new ArrayList<>(graph.getEdges());
        Collections.sort(allEdges);

        DSU dsu = new DSU(graph.getVertices ());
        List<Edge> mst = new ArrayList<>();
        int cost = 0;

        for (Edge e : allEdges) {
            int u = dsu.find(e.src);
            int v = dsu.find(e.dest);
            if (u != v) {
                mst.add(e);
                cost += e.weight;
                dsu.union(u, v);
            }
        }

        long end = System.nanoTime();
        return new ResultsMst("Kruskal", mst, cost, end - start);
    }
}

