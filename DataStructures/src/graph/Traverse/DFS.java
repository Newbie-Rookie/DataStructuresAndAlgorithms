package graph.Traverse;

import graph.Node;

import java.util.HashSet;
import java.util.Stack;

/**
 * 深度优先遍历
 */
public class DFS {
    public void dfs(Node node){
        if(node == null){
            return;
        }
        // 存储遍历路径上的点
        Stack<Node> stack = new Stack<>();
        // 存储已遍历过的点
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            node = stack.pop();
            for(Node next : node.nexts){
                if(!set.contains(next)){
                    stack.push(node);
                    stack.push(next);
                    set.add(next);
                    node = next;
                    System.out.println(node.value);
                    break;
                }
            }
        }
    }
}
