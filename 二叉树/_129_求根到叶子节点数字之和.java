package 二叉树;

public class _129_求根到叶子节点数字之和 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int res = getsum(root, 0);
        return res;
    }

    private int getsum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int temp = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return Math.addExact(getsum(root.left, temp), getsum(root.right, temp));
    }

    public static void main(String[] args) {
        _129_求根到叶子节点数字之和 a = new _129_求根到叶子节点数字之和();
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 2, 3};
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.sumNumbers(node));
    }
}
