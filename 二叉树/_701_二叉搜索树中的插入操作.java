package 二叉树;

public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        _701_二叉搜索树中的插入操作 a = new _701_二叉搜索树中的插入操作();
        Integer[] data = {40, 20, 60, 10, 30, 50, 70};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.insertIntoBST(node, 25));
    }
}
