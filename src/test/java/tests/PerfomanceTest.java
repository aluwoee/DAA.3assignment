package tests;

import algos.KruskalAlgorithm;
import algos.PrimAlgorithm;
import data.Graph;
import data.ResultsMst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTest {

    @Test
    public void testExecutionTimesAndWeightsNonNegative() {
        Graph g = TestHelper.makeSampleGraph();

        ResultsMst prim = PrimAlgorithm.findMST(g);
        ResultsMst kruskal = KruskalAlgorithm.findMST(g);

        assertTrue(prim.getExecutionTime() >= 0, "Prim time must be >= 0");
        assertTrue(kruskal.getExecutionTime() >= 0, "Kruskal time must be >= 0");
        assertTrue(prim.getTotalWeight() >= 0, "Prim weight must be >= 0");
        assertTrue(kruskal.getTotalWeight() >= 0, "Kruskal weight must be >= 0");
    }
}

