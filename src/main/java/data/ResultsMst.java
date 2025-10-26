package data;

import java.util.List;

public class ResultsMst {
    private String algorithmName;
    private List<Edge> mstEdges;
    private int totalWeight;
    private long timeNs;

    public ResultsMst(String algorithmName, List<Edge> mstEdges, int totalWeight, long timeNs) {
        this.algorithmName = algorithmName;
        this.mstEdges = mstEdges;
        this.totalWeight = totalWeight;
        this.timeNs = timeNs;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public List<Edge> getMstEdges() {
        return mstEdges;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public long getExecutionTime() {
        return timeNs;
    }
}

