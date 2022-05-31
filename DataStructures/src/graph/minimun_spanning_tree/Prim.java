package graph.minimun_spanning_tree;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.*;

/**
 * 最小生成树算法：Prim算法
 */
public class Prim {
    /**
     * 适用于单个连通图
     * @param graph
     */
    public void prim1(Graph graph){
        // 解锁的边放入小根堆
        PriorityQueue<Edge> minEdge = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        // 存储解锁的点
        Set<Node> nodeSet = new HashSet<>();
        // 存储挑选的边
        Set<Edge> edgeSet = new HashSet<>();
        // 先随机挑选一个点
        List<Node> nodes = (List<Node>)graph.nodes.values();
        // 将解锁的点和边放入对应的set集合中
        nodeSet.add(nodes.get(0));
        for(Edge edge : nodes.get(0).edges) {
            minEdge.offer(edge);
        }
        // 直到所有点解锁/minEdge为空
        while(nodeSet.size() != nodes.size()){
            Edge edge = minEdge.poll();
            if(!nodeSet.contains(edge.to)){
                nodeSet.add(edge.to);
                edgeSet.add(edge);
                // 将新解锁的边放入小根堆中
                for(Edge e : edge.to.edges){
                    minEdge.offer(edge);
                }
            }
        }
    }

    /**
     * 适用于森林（多个连通图）
     * @param graph
     */
    public void prim2(Graph graph){
        // 存储已解锁的边
        PriorityQueue<Edge> minEdge = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        // 存储已解锁的点
        Set<Node> nodeSet = new HashSet<>();
        // 存储挑选的边
        Set<Edge> edgeSet = new HashSet<>();
        // 该循环的作用是解决森林/多连通图的问题
        for(Node node : graph.nodes.values()){
            // 判断点是否已解锁
            if(!nodeSet.contains(node)){
                // 新解锁的点
                nodeSet.add(node);
                // 新解锁的边
                for(Edge edge : node.edges){
                    minEdge.offer(edge);
                }
                while(!minEdge.isEmpty()){
                    Edge edge = minEdge.poll();
                    if(!nodeSet.contains(edge.to)){
                        nodeSet.add(edge.to);
                        edgeSet.add(edge);
                        for(Edge e : edge.to.edges){
                            minEdge.offer(e);
                        }
                    }
                }
            }
        }
    }
}
