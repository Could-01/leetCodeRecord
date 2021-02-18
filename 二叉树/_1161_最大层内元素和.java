package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _1161_最大层内元素和 {
    public int maxLevelSum(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0, maxlevel = 0, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int num = 0, size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                num += tmp.val;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            level++;
            if (num > max) {
                max = num;
                maxlevel = level;
            }
        }
        return maxlevel;
    }

    public static void main(String[] args) {
        _1161_最大层内元素和 a = new _1161_最大层内元素和();
        GenergicTree g = new GenergicTree();
        System.out.println(a.maxLevelSum(g.levelOrderGenergic(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127})));
    }
}

class Test_1161 {
    List<Integer> list = new ArrayList<>();
    public int maxLevelSum(TreeNode root) {
        int res = Integer.MIN_VALUE;
        int level = 0;
        levelsOrder(root, level);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > res) {
                res = list.get(i);
                level = i;
            }
        }
        return level + 1;
    }

    void levelsOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        } else {
            list.set(level, list.get(level) + root.val);
        }
        levelsOrder(root.left, level + 1);
        levelsOrder(root.right, level + 1);
    }

    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Test_1161 a = new Test_1161();
        Integer[] data1 = {1, 7, 0, 7, -8, null, null};
        Integer[] data = new Integer[]{1};
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.maxLevelSum(node));
    }
}