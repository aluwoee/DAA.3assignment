package view;

import data.Edge;
import data.Graph;
import data.ResultsMst;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GraphCanvas extends JPanel {

    private final Graph graph;
    private final ResultsMst result;
    private static final int NODE_RADIUS = 18;

    public GraphCanvas(Graph graph, ResultsMst result) {
        this.graph = graph;
        this.result = result;
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random random = new Random(20);
        int n = graph.getVertices();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = random.nextInt(getWidth() - 100) + 50;
            int y = random.nextInt(getHeight() - 100) + 50;
            points[i] = new Point(x, y);
        }

        Set<String> mstLines = new HashSet<>();
        for (Edge e : result.getMstEdges()) {
            mstLines.add(e.src + "-" + e.dest);
            mstLines.add(e.dest + "-" + e.src);
        }

        for (Edge e : graph.getEdges()) {
            Point p1 = points[e.src];
            Point p2 = points[e.dest];

            if (mstLines.contains(e.src + "-" + e.dest))
                g.setColor(Color.RED);
            else
                g.setColor(Color.LIGHT_GRAY);

            g.drawLine(p1.x, p1.y, p2.x, p2.y);

            g.setColor(Color.BLUE);
            int midX = (p1.x + p2.x) / 2;
            int midY = (p1.y + p2.y) / 2;
            g.drawString(String.valueOf(e.weight), midX, midY);
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < n; i++) {
            Point p = points[i];
            g.fillOval(p.x - NODE_RADIUS / 2, p.y - NODE_RADIUS / 2, NODE_RADIUS, NODE_RADIUS);
            g.drawString(String.valueOf(i), p.x - 4, p.y - 8);
        }
    }

    public static void display(Graph graph, ResultsMst result, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new GraphCanvas(graph, result));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
