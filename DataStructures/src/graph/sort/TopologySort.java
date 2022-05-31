package graph.sort;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.*;

/**
 * 拓补排序
 */
public class TopologySort {
    public void topologySort(Graph graph){
        // k：节点  v：入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的点进队列
        Deque<Node> zeroDeque = new ArrayDeque<>();
        for (Node node : graph.nodes.values()){
             inMap.put(node, node.in);
             if(node.in == 0){
                 zeroDeque.add(node);
             }
        }
        // 拓补排序的结果
        List<Node> result = new ArrayList<>();
        while(!zeroDeque.isEmpty()){
            Node node = zeroDeque.poll();
            result.add(node);
            for(Node next : node.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroDeque.offer(next);
                }
            }
        }
    }
}
