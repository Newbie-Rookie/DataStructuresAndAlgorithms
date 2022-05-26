package tree.Brinary;

import tree.Brinary.Judge.JudgeSBT;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 求两节点的最近公共祖先
 */
public class Lca {

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
        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(5);
        root.left.left = p;
        root.left.right = q;
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(lca1(root, p, q).val);
        System.out.println(lca2(root, p, q).val);
    }

    /**
     * 哈希表+有序表
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lca1(TreeNode root, TreeNode p, TreeNode q){
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        map.put(root, null);
        preorder(root, map);
        HashSet<TreeNode> set = new HashSet<>();
        while(p != null){
            set.add(p);
            p = map.get(p);
        }
        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }

    /**
     * 先序遍历保存子节点与父节点的映射关系
     * @param root
     * @param map
     */
    public static void preorder(TreeNode root, HashMap<TreeNode,TreeNode> map){
        if(root == null) return;
        map.put(root.left, root);
        map.put(root.right, root);
        preorder(root.left, map);
        preorder(root.right, map);
    }

    /**
     * 分情况：(1)一节点为另一节点的祖先； (2)一节点不为另一节点的祖先
     * @return
     */
    public static TreeNode lca2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lca2(root.left, p, q);
        TreeNode right = lca2(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
