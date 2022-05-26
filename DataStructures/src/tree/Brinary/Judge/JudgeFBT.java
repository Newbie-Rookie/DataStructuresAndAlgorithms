package tree.Brinary.Judge;

/**
 * 树形DP判断满二叉树
 */
public class JudgeFBT {

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

        ReturnData returnData = isFBT(root);
        System.out.println(((1 << returnData.height) - 1) == returnData.nodes);
    }

    static class ReturnData{
        public int height;
        public int nodes;

        public ReturnData(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static ReturnData isFBT(TreeNode root){
        if(root == null){
            return new ReturnData(0, 0);
        }
        ReturnData leftData = isFBT(root.left);
        ReturnData rightData = isFBT(root.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodes = leftData.nodes + rightData.nodes + 1;
        return new ReturnData(height, nodes);
    }
}
