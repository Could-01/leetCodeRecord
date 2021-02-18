package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _面试题_04_05_合法二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode maxLeft = root.left, minRight = root.right;
        // 找寻左子树中的最右（数值最大）节点
        while (maxLeft != null && maxLeft.right != null)
            maxLeft = maxLeft.right;
        // 找寻右子树中的最左（数值最小）节点
        while (minRight != null && minRight.left != null)
            minRight = minRight.left;
        // 当前层是否合法
        boolean ret = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val < minRight.val);
        // 进入左子树和右子树并判断是否合法
        return ret && isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        _面试题_04_05_合法二叉搜索树 b = new _面试题_04_05_合法二叉搜索树();
        Integer[] a = new Integer[]{4, 2, 6, 8, 3, 5, 7};
        //Integer[] a = new Integer[]{4, 2, 6, null, null, 5, 7};
        TreeNode node = new GenergicTree().levelOrderGenergic(a);
        System.out.println(b.isValidBST(node));
    }
}
