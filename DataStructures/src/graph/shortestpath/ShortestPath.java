package graph.shortestpath;

import graph.Edge;
import graph.Node;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 最短路径：迪杰斯特拉算法
 */
public class ShortestPath {

    /**
     * 最短路径：迪杰斯特拉算法
     * @param head
     * @return 返回每个节点与起点的最短路径
     */
    public HashMap<Node, Integer> ShortestPath(Node head){
        // 每个点与起点的距离
        HashMap<Node, Integer> disMap = new HashMap<>();
        disMap.put(head, 0);
        // 记录已为最小距离的点
        HashSet<Node> selectedNodes = new HashSet<>();
        // 取出与起点最小距离且未被确定的点
        Node minNode = getMinDisAndUnselectedNode(disMap, selectedNodes);
        while(!disMap.isEmpty()){
            // 遍历该点所有的边
            for(Edge edge : head.edges){
                if(!disMap.containsKey(edge.to)){
                    disMap.put(edge.to, disMap.get(minNode) + edge.weight);
                }
                disMap.put(edge.to, Math.min(disMap.get(edge.to), disMap.get(minNode) + edge.weight));
            }
            // 将该点添加为已选定
            selectedNodes.add(minNode);
            // 取出与起点最小距离且未被确定的点
            minNode = getMinDisAndUnselectedNode(disMap, selectedNodes);
        }
        return disMap;
    }

    /**
     * 取出与起点最小距离且未被确定的点
     * @param disMap
     * @param selectedNodes
     * @return
     */
    public Node getMinDisAndUnselectedNode(HashMap<Node, Integer> disMap, HashSet<Node> selectedNodes){
        Node minNode = null;
        int minDis = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> m : disMap.entrySet()){
            if(!selectedNodes.contains(m.getKey()) && minDis > m.getValue()){
                minNode = m.getKey();
                minDis = m.getValue();
            }
        }
        return minNode;
    }
}
