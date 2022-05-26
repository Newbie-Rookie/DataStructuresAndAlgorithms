package tree.Brinary.Judge;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Judge {

    static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
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

        System.out.println(isSBT(root));
        System.out.println(isSBT2(root));
        System.out.println(isCBT(root));
        System.out.println(isFBT(root));
        System.out.println(isFBT2(root));
    }

    public static int maxNum = Integer.MIN_VALUE;

    /**
     * 判断排序二叉树
     * @param root
     * @return
     */
    public static boolean isSBT(TreeNode root){
        if(root == null) return true;
        if(isSBT(root.left) || root.val < maxNum){
            return false;
        }
        maxNum = root.val;
        return isSBT(root.right);
    }

    /**
     * 判断排序二叉树
     * @param root
     * @return
     */
    public static boolean isSBT2(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        int maxNum = Integer.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                if(maxNum > root.val){
                    return false;
                }else{
                    maxNum = root.val;
                }
                root = root.right;
            }
        }
        return true;
    }

    /**
     * 判断完全二叉树
     * @param root
     * @return
     */
    public static boolean isCBT(TreeNode root){
        if(root == null) return true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        // 是否遇到过左右两孩子不双全的情况
        boolean flag = false;
        TreeNode l = null, r = null;
        while(!deque.isEmpty()){
            root = deque.poll();
            l = root.left;
            r = root.right;
            // 如果再次遇到左右孩子不全/有右无左，返回false
            if((flag && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if(l != null) deque.offer(l);
            if(r != null) deque.offer(r);
            // 第一次遇到左右孩子不全
            if(l == null || r == null) flag = true;
        }
        return true;
    }

    /**
     * 判断满二叉树
     * @param root
     * @return
     */
    public static boolean isFBT(TreeNode root){
        if(root == null) return true;
        if((root.left != null && root.right == null) || (root.left == null && root.right != null)){
            return false;
        }
        return isFBT(root.left) && isFBT(root.right);
    }

    /**
     * 判断满二叉树
     * @param root
     * @return
     */
    public static boolean isFBT2(TreeNode root){
        if(root == null) return true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int depth = 1;
        while(!deque.isEmpty()){
            int size = deque.size();
            if(size != Math.pow(2, depth-1)){
                return false;
            }
            for(int i = 1;i <= size;++i){
                TreeNode node = deque.poll();
                if(node.left != null) deque.offer(node.left);
                if(node.right != null) deque.offer(node.right);
            }
            depth++;
        }
        return true;
    }
}
