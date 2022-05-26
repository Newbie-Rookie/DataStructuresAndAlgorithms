package tree.Brinary.Judge;

/**
 * 树形DP判断平衡二叉树
 */
public class JudgeBBT {
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
        // root.left.left.left = new TreeNode(8);
        // root.left.left.left.left = new TreeNode(9);

        System.out.println(isBBT(root).isBBT);
    }

    static class ReturnData{
        boolean isBBT;
        public int height;

        public ReturnData(boolean isBBT, int height){
            this.isBBT = isBBT;
            this.height = height;
        }
    }

    public static ReturnData isBBT(TreeNode root){
        if(root == null){
            return new ReturnData(true, 0);
        }
        ReturnData leftData = isBBT(root.left);
        ReturnData rightData = isBBT(root.right);
        boolean isBBT = leftData.isBBT && rightData.isBBT && Math.abs(leftData.height - rightData.height) < 2;
        int height = Math.max(leftData.height, rightData.height) + 1;
        return new ReturnData(isBBT, height);
    }
}
