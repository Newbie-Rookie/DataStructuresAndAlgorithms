package tree.Brinary;

import java.util.Stack;

public class Serizaliable {

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

        String rootStr = serialize(root);
        root = deserialize(rootStr);
        System.out.println(serialize(root));
    }

    /*
    public static String serizaliable(TreeNode root){
        StringBuffer str = new StringBuffer();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            if(root != null){
                str.append(root.val + ",");
                stack.push(root.right);
                stack.push(root.left);
            }else{
                str.append("#,");
            }
        }
        return str.toString();
    }
    */

    /**
     * 序列化
     * @param root
     * @return
     */
    public static String serialize(TreeNode root){
        if(root == null) return "#,";
        String s = root.val + ",";
        s += serialize(root.left);
        s += serialize(root.right);
        return s;
    }

    /**
     * 反序列化
     * @param rootStr
     * @return
     */
    public static TreeNode deserialize(String rootStr){
        String[] str = rootStr.split(",");
        return buildTree(str);
    }

    // 或先将所有字符串放入队列、消费队列
    public static int index = 0;

    /**
     * 根据先序遍历建树
     * @param str
     * @return
     */
    public static TreeNode buildTree(String[] str){
        if("#".equals(str[index])){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[index++]));
        root.left = buildTree(str);
        index++;
        root.right = buildTree(str);
        return root;
    }
}
