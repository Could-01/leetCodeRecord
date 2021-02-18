package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1325_删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,2,null,2,4};
        List<Integer> list = new ArrayList(Arrays.asList(a));
        GenergicTree l = new GenergicTree();
        TreeNode node = l.levelOrderGenergic(list);
        _1325_删除给定值的叶子节点 b = new _1325_删除给定值的叶子节点();
        System.out.println(b.removeLeafNodes(node, 2));
    }
}
