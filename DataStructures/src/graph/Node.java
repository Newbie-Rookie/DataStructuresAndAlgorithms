package graph;

import java.util.ArrayList;

/**
 * 点
 */
public class Node {
    // 点值
    public int value;
    // 入度
    public int in;
    // 出度
    public int out;
    // 本点指向的点
    public ArrayList<Node> nexts;
    // 属于本点的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
