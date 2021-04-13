package 二叉树;

public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int value = root.val;
        if (p.val == value) {
            return p;
        }
        if (q.val == value) {
            return q;
        }
        if (p.val < value && q.val < value) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > value && q.val > value) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }


    public static void main(String[] args) {
        _235_二叉搜索树的最近公共祖先 a = new _235_二叉搜索树的最近公共祖先();
        Integer[] data = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = new GenergicTree().levelOrderGenergic(data);
        System.out.println(a.lowestCommonAncestor(root, root.left, root.right));
    }
}
