package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 */
public class Graph {
    // 点集(可替换为数组(0-n))
    public HashMap<Integer, Node> nodes;
    // 边集
    public HashSet<Edge> edges;

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
