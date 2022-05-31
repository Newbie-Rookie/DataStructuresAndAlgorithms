package graph.shortestpath;

import graph.Edge;
import graph.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 最短路径：迪杰斯特拉算法
 */
public class ShortestPath {

    public void ShortestPath1(Node head){
        // 每个点与起点的距离
        HashMap<Node, Integer> disMap = new HashMap<>();
        disMap.put(head, 0);
        // 记录每个点与起点的最短距离
        HashMap<Node, Integer> minDisMap = new HashMap<>();
        while(!disMap.isEmpty()){
            for(Edge edge : head.edges){
                if(disMap.containsKey(edge.to)){
                    int weight = disMap.get(edge.from) + edge.weight;
                    if(disMap.get(edge.to) > weight){
                        disMap.put(edge.to, weight);
                    }
                }else{
                    disMap.put(edge.to, disMap.get(edge.from) + edge.weight);

                }
            }
            minDisMap.put(head,disMap.remove(head));
            int dis = Integer.MAX_VALUE;
            // 找当前距离起点最小的点
            for(Map.Entry<Node, Integer> m : disMap.entrySet()){
                if(m.getValue() < dis){
                    head = m.getKey();
                    dis = m.getValue();
                }
            }
        }
    }

    public void ShortestPath2(Node head){
        // 每个点与起点的距离
        HashMap<Node, Integer> disMap = new HashMap<>();
        disMap.put(head, 0);
        // 记录每个点与起点的最短距离
        HashMap<Node, Integer> minDisMap = new HashMap<>();
        while(!disMap.isEmpty()){
            for(Edge edge : head.edges){
                if(disMap.containsKey(edge.to)){
                    int weight = disMap.get(edge.from) + edge.weight;
                    if(disMap.get(edge.to) > weight){
                        disMap.put(edge.to, weight);
                    }
                }else{
                    disMap.put(edge.to, disMap.get(edge.from) + edge.weight);

                }
            }
            minDisMap.put(head,disMap.remove(head));
            int dis = Integer.MAX_VALUE;
            // 找当前距离起点最小的点
            for(Map.Entry<Node, Integer> m : disMap.entrySet()){
                if(m.getValue() < dis){
                    head = m.getKey();
                    dis = m.getValue();
                }
            }
        }
    }
}
