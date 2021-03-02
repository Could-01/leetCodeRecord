package 二叉树;

public class MorrisVisited {
    // 莫里斯前序迭代遍历
    // 莫里斯后序遍历是反转前序所得数组
    public void MorrisPreOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;    // 记录当前节点位置
        while (cur != null) {
            if (cur.left == null) {   // 左节点为空，移到右子节点
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) { // 遍历到左子树的最右侧节点
                    prev = prev.right;
                }
                if (prev.right == null) {        // 建立返回父节点连接
                    prev.right = cur;
                    System.out.print(cur.val + " ");          // 注意添加元素到数组的代码位置移到了这里
                    cur = cur.left;
                } else {                        // 左子树建立了连接，说明遍历完了，可以拆除连接
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    // 莫里斯中序遍历
    /*
     * 整个遍历的过程中只需要两个指针——当前指针cur和临时前驱指针prev，具体的过程如下
     * 如果左子节点是空，录入当前节点，当前指针cur指向右子节点
     * 如果左子节点不是空，遍历左子节点的最右侧右子节点，找到最右侧叶节点，在寻找的过程中可能出现两种情况：
     *          如果遍历到的叶节点的右子节点是空，把叶节点的右子节点指向cur节点，cur移向左子节点
     *          如果遍历到的叶节点的右子节点是cur节点，表示原来的叶节点到cur节点连接已经存在，现在遍历结束了，需要复原，置节点的右子节点为空，在录入了cur节点之后，cur移到自己的右子节点
     * 重复上面两步直到当前节点为空
     * */
    public void MorrisInOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;    // 记录当前节点位置
        while (cur != null) {
            if (cur.left == null) {   // 左节点为空，移到右子节点
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) { // 遍历到左子树的最右侧节点
                    prev = prev.right;
                }
                if (prev.right == null) {        // 建立返回父节点连接
                    prev.right = cur;
                    cur = cur.left;
                } else {                        // 左子树建立了连接，说明遍历完了，可以拆除连接
                    System.out.print(cur.val + " ");          // 中序遍历录入当前节点
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        MorrisVisited m = new MorrisVisited();
        TreeNode node = new GenergicTree().levelOrderGenergic(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        m.MorrisInOrder(node);
    }
}
