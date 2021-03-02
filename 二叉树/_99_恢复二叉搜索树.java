package 二叉树;

public class _99_恢复二叉搜索树 {

    //用两个变量x，y来记录需要交换的节点
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (pre != null) {
            if (pre.val > node.val) {
                y = node;
                if (x == null) x = pre;
            }
        }
        pre = node;
        dfs(node.right);
    }

    // 莫里斯中序遍历替换
    public void recoverTree1(TreeNode root) {
        if (root == null) return;
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        TreeNode tmp = null;
        while (root != null) {
            if (root.left != null) {
                tmp = root.left;
                while (tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    if (pre != null && pre.val > root.val) {
                        y = root;
                        if (x == null) x = pre;
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            } else {
                if (pre != null && pre.val > root.val) {
                    y = root;
                    if (x == null) x = pre;
                }
                pre = root;
                root = root.right;
            }
        }
        if (x != null && y != null) {
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }


    public static void main(String[] args) {
        _99_恢复二叉搜索树 a = new _99_恢复二叉搜索树();
        TreeNode root = new GenergicTree().levelOrderGenergic(new Integer[]{3, 1, 4, null, null, 2});
        a.recoverTree(root);
        System.out.println(root);
    }
}
