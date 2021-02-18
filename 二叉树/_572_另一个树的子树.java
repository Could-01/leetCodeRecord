package 二叉树;

public class _572_另一个树的子树 {
    boolean flag = true;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t == null) {
            return false;
        }
        if (s == null && t != null) {
            return false;
        }
        if (s == null) {
            return true;
        }
        // 前序遍历 解决问题
        if (s.val == t.val) {
            flag = false;
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        if (flag) {
            return isSubtree(s.left, t) && isSubtree(s.right, t);
        }
        return true;
    }

    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 1};
        Integer[] data1 = {1};
        TreeNode node1 = g.levelOrderGenergic(data);
        TreeNode node2 = g.levelOrderGenergic(data1);
        _572_另一个树的子树 a = new _572_另一个树的子树();
        System.out.println(a.isSubtree(node1, node2));
    }
}

class Test_572 {
    // 什么时候结束？ 等到有树为空时结束，代表遍历完了。
    // 每层干什么？ 查看val是否相同。
    // 给下一层什么？ 是否相同的判断！使用前端遍历

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;   // t 为 null 一定都是 true
        if (s == null) return false;  // 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    /**
     * 判断两棵树是否相同
     */
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {3, 4, 5, 1, 2};
        Integer[] data1 = {4, 1, 2};
        TreeNode node1 = g.levelOrderGenergic(data);
        TreeNode node2 = g.levelOrderGenergic(data1);
        Test_572 a = new Test_572();
        System.out.println(a.isSubtree(node1, node2));
    }
}