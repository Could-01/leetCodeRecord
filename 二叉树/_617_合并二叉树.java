package 二叉树;

public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        _617_合并二叉树 a = new _617_合并二叉树();
        GenergicTree g = new GenergicTree();
        TreeNode n1 = g.levelOrderGenergic(new Integer[]{-4, null, 5, 2, 9, 0, 3, 7, null, null, 1, null, null, 6, 8});
        TreeNode n2 = g.levelOrderGenergic(new Integer[]{9, 7, null, 6, 7501});

        System.out.println(a.mergeTrees(n1, n2));
    }

}
