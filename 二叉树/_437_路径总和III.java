package 二叉树;

public class _437_路径总和III {
    int Sum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        getSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return Sum;
    }

    public void getSum(TreeNode node, int targetSum) {
        if (node == null) return;
        if (targetSum - node.val == 0) {
            Sum++;
        }
        getSum(node.left, targetSum - node.val);
        getSum(node.right, targetSum - node.val);
    }

    public static void main(String[] args) {
        _437_路径总和III a = new _437_路径总和III();
        Integer[] data = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.pathSum(node, 8));
    }
}
