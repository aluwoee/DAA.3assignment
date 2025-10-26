import algos.KruskalAlgorithm;
import algos.PrimAlgorithm;
import data.Graph;
import data.ResultsMst;
import files.JsonIO;

import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] jsonFiles = {
                "src/main/resources/input_small.json",
                "src/main/resources/input_medium.json",
                "src/main/resources/input_large.json",
                "src/main/resources/input_extralarge.json"
        };

        String csvFile = "src/main/resources/output_table.csv";
        List<String[]> results = new ArrayList<>();
        results.add(new String[]{"File", "GraphID", "Vertices", "Prim (ms)", "Kruskal (ms)", "Total Weight"});

        for (String file : jsonFiles) {
            Map<String, Graph> graphs = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));
            graphs.putAll(JsonIO.readGraphs(file));

            for (Map.Entry<String, Graph> entry : graphs.entrySet()) {
                String id = entry.getKey();
                Graph g = entry.getValue();

                ResultsMst prim = PrimAlgorithm.findMST(g);
                ResultsMst kruskal = KruskalAlgorithm.findMST(g);

                results.add(new String[]{
                        file.substring(file.lastIndexOf("/") + 1),
                        id,
                        String.valueOf(g.getVertices()),
                        String.format("%.3f", prim.getExecutionTime() / 1_000_000.0),
                        String.format("%.3f", kruskal.getExecutionTime() / 1_000_000.0),
                        String.valueOf(kruskal.getTotalWeight())
                });
            }
        }

        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] row : results) {
                writer.write(String.join(",", row));
                writer.write("\n");
            }
            System.out.println("Results saved to " + csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
