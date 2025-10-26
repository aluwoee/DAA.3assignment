# Design and Analysis of Algorithms  
### Assignment 3 — Minimum Spanning Tree (MST)

#### Objective  
The goal of this project is to compare two well-known Minimum Spanning Tree algorithms — **Prim’s** and **Kruskal’s** — and analyze their performance on graphs of different sizes and densities.  
Both algorithms are implemented in **Java (Maven)**, and results are stored in JSON and CSV formats.

## Overview  
The program calculates MSTs, measures **execution time**, **number of vertices**, and **total MST cost**.  
A visualization window is available to display how the MST connects all nodes in the graph.

## Project Structure  

**Main folders (src/main/java):**  
- `algos/` – contains Prim and Kruskal implementations  
- `io/` – JSON file reading and writing  
- `data/` – includes models (Edge, Graph, ResultsMst)  
- `view/` – handles graph visualization and interface  
- `Main.java` – executes all graphs and exports results  

**Resources (src/main/resources):**  
- `input_small.json`, `input_medium.json`, `input_large.json`, `input_extralarge.json`  
- `output_table.csv` – combined results of algorithm runs  

**Tests (src/test/java):**  
- `CompareAlgoTest`  
- `StructureMstTest`  
- `PerformanceTest`  
- `TestHelper`  

## Input Description  
Each input JSON file contains several graphs described by vertices and edges.  
- **Vertices** represent city areas  
- **Edges** represent possible roads with costs  

| File | ID Range | Size (Vertices) |
|------|-----------|----------------|
| input_small.json | 1–5 | 5–25 |
| input_medium.json | 6–15 | 50–300 |
| input_large.json | 16–25 | 350–800 |
| input_extralarge.json | 26–28 | 1300–2000 |

## Algorithm Summary  

### Prim’s Algorithm  
Builds the MST by continuously selecting the smallest edge that connects visited and unvisited vertices.  
Efficient for **dense graphs**.  
Time complexity: **O(E log V)**  

### Kruskal’s Algorithm  
Sorts all edges and connects components using a **Union-Find** structure.  
Works better on **sparse graphs**.  
Time complexity: **O(E log E)**  

## Experimental Results  
This table shows shortened results of execution time (in milliseconds) and MST total weights.

| File | Graph ID | Vertices | Prim (ms) | Kruskal (ms) | MST Weight |
|------|-----------|-----------|------------|---------------|-------------|
| input_small.json | 1 | 5 | 0.54 | 0.31 | 94 |
| input_small.json | 3 | 15 | 0.08 | 0.03 | 222 |
| input_medium.json | 7 | 75 | 0.01 | 0.01 | 70 |
| input_medium.json | 10 | 150 | 2.58 | 0.26 | 4338 |
| input_large.json | 18 | 450 | 7.33 | 1.36 | 12926 |
| input_extralarge.json | 27 | 1600 | 25.21 | 2.00 | 46820 |

## Analysis and Comparison  
In practice, **Kruskal’s algorithm** showed better results for larger graphs because of efficient edge sorting and union operations.  
**Prim’s algorithm** performed faster for small or dense graphs where the number of edges is high.  
Both algorithms produced identical MST total weights, confirming correctness.

## Conclusions  
- Prim’s algorithm is better suited for **dense** graphs.  
- Kruskal’s algorithm is preferable for **sparse** and **large** graphs.  
- Execution time differences become more noticeable as the graph size increases.  
- Both approaches are valid for real-world optimization tasks such as network or transportation design.

## References  
- T. H. Cormen et al., *Introduction to Algorithms*, MIT Press  
- Course materials from *Design and Analysis of Algorithms*  
- Experimental datasets and visual tests created in Java 17 with Maven

