package 二叉树;

public class _865_具有所有最深节点的最小子树 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        }
        if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    public static void main(String[] args) {
        _865_具有所有最深节点的最小子树 a = new _865_具有所有最深节点的最小子树();
        GenergicTree g = new GenergicTree();
        Integer[] data = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.subtreeWithAllDeepest(node));
    }
}
