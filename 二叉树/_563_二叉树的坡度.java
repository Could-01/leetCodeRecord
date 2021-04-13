package 二叉树;

public class _563_二叉树的坡度 {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }


    private int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    public static void main(String[] args) {
        _563_二叉树的坡度 a = new _563_二叉树的坡度();
        Integer[] data = {4, 2, 9, 3, 5, null, 7};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.findTilt(node));
    }
}
