package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _501_二叉搜索树中的众数 {
    private TreeNode pre = null;
    private int[] ret;
    private int retCount = 0;
    private int maxCount = 0;
    private int currCount = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        pre = null;
        ret = new int[retCount];
        retCount = 0;
        currCount = 0;
        inOrder(root);
        return ret;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != null && pre.val == root.val)
            currCount++;
        else
            currCount = 1;
        if (currCount > maxCount) {
            maxCount = currCount;
            retCount = 1;
        } else if (currCount == maxCount) {
            if (ret != null)
                ret[retCount] = root.val;
            retCount++;
        }
        pre = root;
        inOrder(root.right);
    }


    public static void main(String[] args) {
        _501_二叉搜索树中的众数 a = new _501_二叉搜索树中的众数();
        TreeNode node = new GenergicTree().levelOrderGenergic(new Integer[]{1, null, 2, 2});
        System.out.println(Arrays.toString(a.findMode(node)));
    }
}
