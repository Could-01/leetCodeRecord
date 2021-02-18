package 二叉树;

import java.util.*;

public class _958_二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        if (root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (leaf && !isLeaf(node)) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) { // node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else { // node.right == null
                leaf = true;
            }
        }
        return true;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        _958_二叉树的完全性检验 a = new _958_二叉树的完全性检验();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left = root2;
        root1.right = root3;
        root2.right = root5;
        root2.left = root4;
        root3.right = root6;
        System.out.println(a.isCompleteTree(root1));
    }
}

class Test_958 {
    private int size = 0;
    private int last = 0;

    public boolean isCompleteTree(TreeNode root) {
        traverse(root, 1);
        return size == last;
    }

    private void traverse(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        size++;
        last = Math.max(last, index);
        traverse(root.left, index * 2);
        traverse(root.right, index * 2 + 1);
    }


    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 2, 3, 4, 5, 6};
        Test_958 t = new Test_958();
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(t.isCompleteTree(node));
    }
}