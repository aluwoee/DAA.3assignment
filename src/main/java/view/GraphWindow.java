package view;

import algos.KruskalAlgorithm;
import algos.PrimAlgorithm;
import data.Graph;
import data.ResultsMst;
import files.JsonIO;

import java.util.Map;
import java.util.Scanner;

public class GraphWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the JSON file to open:");
        System.out.println("1 - input_small.json");
        System.out.println("2 - input_medium.json");
        System.out.println("3 - input_large.json");
        System.out.println("4 - input_extralarge.json");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        String filePath = switch (choice) {
            case 1 -> "src/main/resources/input_small.json";
            case 2 -> "src/main/resources/input_medium.json";
            case 3 -> "src/main/resources/input_large.json";
            case 4 -> "src/main/resources/input_extralarge.json";
            default -> null;
        };

        if (filePath == null) {
            System.out.println("Invalid option selected.");
            return;
        }

        System.out.print("Enter the Graph ID: ");
        String graphId = scanner.next();

        Map<String, Graph> graphs = JsonIO.readGraphs(filePath);
        Graph selectedGraph = graphs.get(graphId);

        if (selectedGraph == null) {
            System.out.println("Graph with ID " + graphId + " not found.");
            return;
        }

        ResultsMst prim = PrimAlgorithm.findMST(selectedGraph);
        ResultsMst kruskal = KruskalAlgorithm.findMST(selectedGraph);

        GraphCanvas.display(selectedGraph, prim, "Prim's MST (Graph " + graphId + ")");
        GraphCanvas.display(selectedGraph, kruskal, "Kruskal's MST (Graph " + graphId + ")");
    }
}
