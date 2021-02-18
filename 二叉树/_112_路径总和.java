package 二叉树;

public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return CheckSum(root, targetSum);
    }

    boolean CheckSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        int temp = target - root.val;
        if (root.left == null && root.right == null) {
            return temp == 0;
        }
        return CheckSum(root.left, temp) || CheckSum(root.right, temp);
    }

    public static void main(String[] args) {
        _112_路径总和 a = new _112_路径总和();
        GenergicTree g = new GenergicTree();
        Integer[] data = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        Integer[] data1 = {1, 2};
        TreeNode node = g.levelOrderGenergic(data1);
        System.out.println(a.hasPathSum(node, 1));
    }
}

class Test_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}