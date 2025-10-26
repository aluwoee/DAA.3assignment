package tests;

import algos.KruskalAlgorithm;
import algos.PrimAlgorithm;
import data.Edge;
import data.Graph;
import data.ResultsMst;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StructureMstTest {

    @Test
    public void testPrimEdgeCount() {
        Graph g = TestHelper.makeSampleGraph();
        ResultsMst prim = PrimAlgorithm.findMST(g);
        assertEquals(g.getVertices() - 1, prim.getMstEdges().size(),
                "Prim MST should have V-1 edges");
    }

    @Test
    public void testKruskalEdgeCount() {
        Graph g = TestHelper.makeSampleGraph();
        ResultsMst kr = KruskalAlgorithm.findMST(g);
        assertEquals(g.getVertices() - 1, kr.getMstEdges().size(),
                "Kruskal MST should have V-1 edges");
    }

    @Test
    public void testPrimNoCycles() {
        Graph g = TestHelper.makeSampleGraph();
        ResultsMst prim = PrimAlgorithm.findMST(g);
        assertFalse(hasCycle(prim.getMstEdges(), g.getVertices()),
                "Prim MST should not contain cycles");
    }

    @Test
    public void testKruskalNoCycles() {
        Graph g = TestHelper.makeSampleGraph();
        ResultsMst kr = KruskalAlgorithm.findMST(g);
        assertFalse(hasCycle(kr.getMstEdges(), g.getVertices()),
                "Kruskal MST should not contain cycles");
    }

    private boolean hasCycle(List<Edge> edges, int vertexCount) {
        int[] parent = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) parent[i] = i;

        for (Edge e : edges) {
            int u = find(parent, e.src);
            int v = find(parent, e.dest);
            if (u == v) return true;
            parent[u] = v;
        }
        return false;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) x = parent[x];
        return x;
    }
}
