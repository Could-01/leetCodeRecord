package 二叉树;

public class _998_最大二叉树II {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        TreeNode right = insertIntoMaxTree(root.right, val);
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        _998_最大二叉树II a = new _998_最大二叉树II();
        Integer[] data = {4, 1, 3, null, null, 2};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.insertIntoMaxTree(node, 5));
    }
}
