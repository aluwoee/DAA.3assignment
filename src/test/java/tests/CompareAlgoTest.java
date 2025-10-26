package tests;

import algos.KruskalAlgorithm;
import algos.PrimAlgorithm;
import data.Graph;
import data.ResultsMst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompareAlgoTest {

    @Test
    public void testSameMstCost() {
        Graph graph = TestHelper.makeSampleGraph();

        ResultsMst prim = PrimAlgorithm.findMST(graph);
        ResultsMst kruskal = KruskalAlgorithm.findMST(graph);

        assertNotNull(prim);
        assertNotNull(kruskal);

        assertEquals(prim.getTotalWeight(), kruskal.getTotalWeight(),
                "Prim and Kruskal should return the same MST total weight");
    }
}
