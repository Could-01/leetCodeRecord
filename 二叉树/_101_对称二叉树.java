package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _101_对称二叉树 {
    public static boolean isSymmetric(TreeNode root) {
        return judge(root, root);
    }

    public static boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return judge(left.left, right.right) && judge(left.right, right.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        _101_对称二叉树 a = new _101_对称二叉树();
        Integer[] data = {1, 2, 2, 2, null, 2};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.isSymmetric(node));
    }
}
