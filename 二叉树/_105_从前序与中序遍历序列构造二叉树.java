package 二叉树;

public class _105_从前序与中序遍历序列构造二叉树 {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        System.out.println("node.val = " + node.val + " pre = " + pre);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        _105_从前序与中序遍历序列构造二叉树 a = new _105_从前序与中序遍历序列构造二叉树();
        int[] pre = {3, 9, 5, 10, 20, 15, 7};
        int[] in = {5, 9, 10, 3, 15, 20, 7};
        TreeNode node = a.buildTree(pre, in);
        System.out.println(node);
    }
}

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        //        int[] pre = {3, 9, 5, 10, 20, 15, 7};
        //        int[] in = {5, 9, 10, 3, 15, 20, 7};
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 5, 10, 20, 15, 7};
        int[] in = {5, 9, 10, 3, 15, 20, 7};
        TreeNode node = new Solution_2().buildTree(pre, in);
        System.out.println(node);
    }
}

class Solution_2 {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre]);
        pre++;
        node.left = build(preorder, inorder, node.val);
        in++;
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 5, 10, 20, 15, 7};
        int[] in = {5, 9, 10, 3, 15, 20, 7};
        TreeNode node = new Solution_2().buildTree(pre, in);
        System.out.println(node);
    }
}