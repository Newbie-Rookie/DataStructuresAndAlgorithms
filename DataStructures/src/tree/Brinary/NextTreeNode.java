package tree.Brinary;

/**
 * 一节点的后继节点
 */
public class NextTreeNode {

    static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode(Integer val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 分情况：(1)该节点有右子树，找该右子树的最左节点
     *        (2)该节点无右子树，找该节点的父节点，直到节点为父节点的左孩子停止
     * @param node
     * @return
     */
    public static TreeNode nextTreeNode(TreeNode node){
        if(node == null) return node;
        if(node.right == null){
            TreeNode parent = node.parent;
            while(parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }else{
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }
}
