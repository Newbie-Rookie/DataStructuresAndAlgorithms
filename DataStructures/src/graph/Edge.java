package graph;

/**
 * 边
 */
public class Edge {
    // 权值
    public int weight;
    // 起点
    public Node from;
    // 终点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
