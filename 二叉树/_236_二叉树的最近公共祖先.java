package 二叉树;

public class _236_二叉树的最近公共祖先 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // LCA 问题
            if (root == null) {
                return root;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            } else if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            }
            return null;
        }


    public static void main(String[] args) {
        _236_二叉树的最近公共祖先 a = new _236_二叉树的最近公共祖先();
        Integer[] data = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.lowestCommonAncestor(root, root.left, root.right));
    }
}
