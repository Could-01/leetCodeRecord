package 二叉树;

public class _111_二叉树的最小深度 {
    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        getdepth(root, 1);
        return min;
    }

    private void getdepth(TreeNode root, int level) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            min = Math.min(level, min);
            return;
        }
        getdepth(root.left, level + 1);
        getdepth(root.right, level + 1);
    }

    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        _111_二叉树的最小深度 a = new _111_二叉树的最小深度();
        Integer[] data = {3};
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.minDepth(node));
    }
}

class Test_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        return minDepth(root, 1, min);
    }

    public int minDepth(TreeNode root, int depth, int min) {
        if (depth >= min) {
            return min;
        }
        if (root.left == null && root.right == null) {
            return depth;
        }
        if (root.left != null) {
            int minTemp = minDepth(root.left, depth + 1, min);
            min = minTemp < min ? minTemp : min;
        }
        if (root.right != null) {
            int minTemp = minDepth(root.right, depth + 1, min);
            min = minTemp < min ? minTemp : min;
        }
        return min;
    }
}