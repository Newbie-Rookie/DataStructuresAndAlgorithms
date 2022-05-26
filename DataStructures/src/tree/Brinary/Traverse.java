package tree.Brinary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 二叉树遍历；先序、中序、后序、层序
 */
public class Traverse {

    static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preorder(root);
        System.out.println("\n-------------------");
        inorder(root);
        System.out.println("\n-------------------");
        postorder(root);
        System.out.println("\n-------------------");
        sequence(root);
        System.out.println("\n-------------------");
        sequenceLen(root);
    }

    public static void traverse(TreeNode root){
        if(root == null) return;
        // 1
        traverse(root.left);
        // 2
        traverse(root.right);
        // 3
    }

    public static void preorder(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public static void inorder(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public static void postorder(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            help.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        while(!help.isEmpty()){
            System.out.print(help.pop().val + " ");
        }
    }

    public static void sequence(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    public static void sequenceLen(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxSize = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            maxSize = Math.max(maxSize, size);
            for(int i = 1;i <= size;++i) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
        System.out.println(maxSize);
    }
}
