package graph.minimun_spanning_tree;

import graph.Edge;
import graph.Graph;
import graph.Node;
import javafx.scene.Parent;

import java.util.*;

/**
 * 最小生成树算法：Kruskal算法
 */
public class Kruskal {
    /**
     * Kruskal算法
     * @param graph
     */
    public Set<Edge> kruskal(Graph graph){
        // 创建并查集并初始化
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        // 将所有边放入小根堆
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for(Edge edge : graph.edges){
            queue.offer(edge);
        }
        // 存储选中的边
        Set<Edge> result = new HashSet<>();
        // 直到根堆为空
        while(!queue.isEmpty()){
            // 取出堆顶的权重最小的边
            Edge edge = queue.poll();
            // 如果这条边的两个端点不属于同一个集合
            if(!unionFind.isSameSet(edge.from, edge.to)){
                result.add(edge);
                // 把这两个点所在的集合连起来
                unionFind.mergeSet(edge.from, edge.to);
            }
        }
        return result;
    }

    /**
     * 并查集
     */
    public static class UnionFind{
        // K：某一节点，V：key节点往上的节点
        private HashMap<Node, Node> fatherMap;
        // K：某一集合的代表节点，V：key所在集合的节点个数
        private HashMap<Node, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        /**
         * 初始化每个集合只有一个点的小集合
         * @param nodes
         */
        public void makeSets(Collection<Node> nodes){
            for(Node node : nodes){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 判断要合并的边的两端点是否在同一集合
         * @param from
         * @param to
         * @return
         */
        public boolean isSameSet(Node from, Node to){
            return findFather(from) == findFather(to);
        }

        /**
         * 寻找某一节点的最上面的节点，作为整个集合的代表节点（减少寻找次数）
         * @param node
         */
        public Node findFather(Node node){
            Stack<Node> stack = new Stack<>();
            // 寻找该节点的最上面节点
            while(node != fatherMap.get(node)){
                stack.push(node);
                node = fatherMap.get(node);
            }
            // 将该节点的最上面节点作为整个集合的代表节点
            while(!stack.isEmpty()){
                fatherMap.put(stack.pop(), node);
            }
            return node;
        }

        /**
         * 合并边两端点所在的集合
         * @param from
         * @param to
         */
        public void mergeSet(Node from, Node to){
            if(from == null || to == null){
                return;
            }
            // 找到两集合的代表节点
            Node fromFather = findFather(from);
            Node toFather = findFather(to);
            // 集合中的点数
            int fromSize = sizeMap.get(fromFather);
            int toSize = sizeMap.get(toFather);
            // 小集合合并到大集合
            if(fromSize <= toSize){
                fatherMap.put(fromFather, toFather);
                sizeMap.put(toFather, fromSize + toSize);
                sizeMap.remove(fromFather);
            }else{
                fatherMap.put(toFather, fromFather);
                sizeMap.put(fromFather, fromSize + toSize);
                sizeMap.remove(toFather);
            }
        }
    }
}
