package 二叉树;

import java.util.*;

public class _1026_节点与其祖先之间的最大差值 {
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(maxAncestorDiff(root.left, root.val, root.val), maxAncestorDiff(root.right, root.val, root.val));
    }

    public int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) return 0;
        if (root.val > max) {
            max = root.val;
        } else if (root.val < min) {
            min = root.val;
        }
        if (root.left == null && root.right == null) return max - min;

        return Math.max(maxAncestorDiff(root.left, max, min), maxAncestorDiff(root.right, max, min));
    }


    public static void main(String[] args) {
        Integer[] i = new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        List<Integer> list1 = new ArrayList(Arrays.asList(i));
        GenergicTree g = new GenergicTree();
        TreeNode node = g.levelOrderGenergic(list1);
        _1026_节点与其祖先之间的最大差值 a = new _1026_节点与其祖先之间的最大差值();
        System.out.println(a.maxAncestorDiff(node));
    }
}

class Test_1026 {
    int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, 0, 100000);
        return ans;
    }

    public void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        System.out.println(" max " + max);
        ans = Math.max(ans, max - min);
        System.out.println(" ans " + ans + " max - min " + (max - min));
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }

    public static void main(String[] args) {
        Integer[] i = new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        List<Integer> list1 = new ArrayList(Arrays.asList(i));
        GenergicTree g = new GenergicTree();
        TreeNode node = g.levelOrderGenergic(list1);
        Test_1026 a = new Test_1026();
        System.out.println(a.maxAncestorDiff(node));
    }
}