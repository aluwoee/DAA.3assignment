package tests;

import data.Graph;

public class TestHelper {

    public static Graph makeSampleGraph() {
        Graph g = new Graph(5);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 4, 6);
        g.addEdge(3, 4, 5);
        return g;
    }
}
