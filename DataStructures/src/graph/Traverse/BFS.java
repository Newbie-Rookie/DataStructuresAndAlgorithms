package graph.Traverse;

import graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

/**
 * 广度优先遍历
 */
public class BFS {
    public void bfs(Node node){
        if(node == null) {
            return;
        }
        // 存储待遍历的点
        Deque<Node> deque = new ArrayDeque<>();
        // 存储已遍历过的点
        HashSet<Node> set = new HashSet<>();
        deque.offer(node);
        set.add(node);
        while(!deque.isEmpty()){
            node = deque.poll();
            System.out.println(node.value);
            for(Node next : node.nexts){
                if(!set.contains(next)){
                    deque.offer(next);
                    set.add(next);
                }
            }
        }
    }
}
