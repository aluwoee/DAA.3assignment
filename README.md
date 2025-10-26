# Design and Analysis of Algorithms  
### Assignment 3 — Minimum Spanning Tree (MST)

#### Objective  
This project explores how **Prim’s** and **Kruskal’s** algorithms can be used to build a minimal-cost connection network between different city districts.  
The goal was to compare the performance and behavior of both algorithms on graphs of various sizes and densities.

---

## Overview  

The implementation is written in **Java (Maven)**.  
Both algorithms generate MSTs, measure their **execution time**, **number of edges**, and **total weight**, and the results are stored in JSON and CSV formats.  
An additional **visualization tool** displays the structure of each graph and its MST connections.

---

## Project Organization  

**Source code (`src/main/java`):**
- `algos/` — contains `PrimAlgorithm.java` and `KruskalAlgorithm.java`
- `io/` — JSON reader and writer
- `data/` — includes data models such as `Edge`, `Graph`, and `ResultsMst`
- `view/` — responsible for visual display and interaction
- `Main.java` — performs MST calculations and saves the results  

**Resources (`src/main/resources`):**
- `input_small.json`, `input_medium.json`, `input_large.json`, `input_extralarge.json`  
- `output_table.csv` — summarized performance results  

**Tests (`src/test/java`):**
- `CompareAlgoTest`
- `StructureMstTest`
- `PerformanceTest`
- `TestHelper`

---

## Input Description  

Each input JSON file describes a set of graphs where:
- **Vertices** represent city areas;
- **Edges** represent possible connections with given costs.

| File | ID Range | Size (Vertices) |
|------|-----------|----------------|
| input_small.json | 1–5 | 5–25 |
| input_medium.json | 6–15 | 50–300 |
| input_large.json | 16–25 | 350–800 |
| input_extralarge.json | 26–28 | 1300–2000 |

---

## Algorithm Summary  

### Prim’s Algorithm  
Prim’s algorithm builds the MST by expanding from a starting vertex and always selecting the smallest available edge.  
It is efficient for **dense graphs**, where many connections exist.  
**Time complexity:** O(E log V)

### Kruskal’s Algorithm  
Kruskal’s method sorts all edges and joins the smallest ones while avoiding cycles.  
It performs better on **sparse graphs**, using a Union-Find structure to manage components.  
**Time complexity:** O(E log E)

---

## Experimental Results  

The output below represents a shortened version of the collected performance data.

| File | Graph ID | Vertices | Prim (ms) | Kruskal (ms) | MST Weight |
|------|-----------|-----------|------------|---------------|-------------|
| input_small.json | 1 | 5 | 0.54 | 0.31 | 94 |
| input_small.json | 3 | 15 | 0.08 | 0.03 | 222 |
| input_medium.json | 7 | 75 | 0.01 | 0.01 | 70 |
| input_medium.json | 10 | 150 | 2.58 | 0.26 | 4338 |
| input_large.json | 18 | 450 | 7.33 | 1.36 | 12926 |
| input_extralarge.json | 27 | 1600 | 25.21 | 2.00 | 46820 |

---

## Analysis and Comparison  

In theoretical and practical results:
- **Prim’s algorithm** shows stable performance for smaller and dense networks.  
- **Kruskal’s algorithm** consistently performs faster on large and sparse graphs due to edge sorting and disjoint set operations.  
- Both algorithms always produce identical MST total weights, confirming correctness.

---

## Conclusions  

- For **dense graphs**, Prim’s algorithm tends to be more efficient.  
- For **sparse or large graphs**, Kruskal’s algorithm is usually faster and easier to implement.  
- Execution time differences grow with graph size, highlighting the importance of algorithm selection in real-world optimization problems.  

Both methods proved correct and efficient for different scenarios of the city network problem.

---

## References  

- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. *Introduction to Algorithms*, MIT Press.  
- Course materials from *Design and Analysis of Algorithms*, Astana IT University.  
- Example datasets generated and tested in Java 17 with Maven.
