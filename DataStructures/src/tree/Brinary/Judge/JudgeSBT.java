package tree.Brinary.Judge;

public class JudgeSBT {
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

        System.out.println(isSBT(root).isSBT);
    }

    static class ReturnData{
        public boolean isSBT;
        public int min;
        public int max;

        public ReturnData(boolean isSBT, int min, int max) {
            this.isSBT = isSBT;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData isSBT(TreeNode root){
        if(root == null){
            return null;
        }
        ReturnData leftData = isSBT(root.left);
        ReturnData rightData = isSBT(root.right);
        int min = root.val;
        int max = root.val;
        if(leftData != null){
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if(rightData != null){
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        boolean isSBT = true;
        if(leftData != null && (leftData.max < root.val)){
            isSBT = false;
        }
        if(rightData != null && (rightData.min > root.val)){
            isSBT = false;
        }
        return new ReturnData(isSBT, min, max);
    }
}
