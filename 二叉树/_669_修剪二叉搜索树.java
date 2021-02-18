package 二叉树;

public class _669_修剪二叉搜索树 {
    //何时结束？ 在寻找到叶子节点结束
    //每层干什么？ 看节点是否属于low ~ high的值
    //给下一层什么？
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val < low || root.val > high) {
                return null;
            }
        }

        if (root.val > high) {
            root = trimBST(root.left, low, high);
        }

        if (root.val < low) {
            root = trimBST(root.right, low, high);
        }
        root.right = trimBST(root.right, low, high);
        return root;
    }


    public TreeNode trimBST1(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        if (root.val < L) // 当前节点值小于最小值，说明当前节点和左节点都不要了，直接把修改了右节点接上去
            root = trimBST1(root.right, L, R);
        else if (root.val > R)// 当前节点值大于最大值，说明当前节点和右节点都不要了，直接把修改了左节点接上去
            root = trimBST1(root.left, L, R);
        else if (root.val == L) {// 当前节点值等于最小值，说明左节点都不要了，直接修改了右节点
            root.left = null;
            root.right = trimBST1(root.right, L, R);
        } else if (root.val == R) {// 当前节点值等于最大值，说明右节点都不要了，直接修改了左节点
            root.right = null;
            root.left = trimBST1(root.left, L, R);
        } else {// 当前在值域范围内，左右都需要修改
            root.left = trimBST1(root.left, L, R);
            root.right = trimBST1(root.right, L, R);
        }
        return root;
    }


    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null)
            return root;
        //处理正常的左节点
        root.left = trimBST2(root.left, L, R);
        //下面两个if相当于删除不满足要求的节点
        if (root.val < L)
            return trimBST2(root.right, L, R);//返回修剪过的右子树。抱有一丝丝期望，希望右子树能够满足要求，因为右子树的值大于当前根节点的值
        if (root.val > R)
            return trimBST2(root.left, L, R);//返回修剪过的左子树，抱有一丝丝期望，希望左子树能够满足要求，因为左子树的值小于当前根节点的值
        //处理正常的右节点
        root.right = trimBST2(root.right, L, R);
        return root;
    }


    public static void main(String[] args) {
        _669_修剪二叉搜索树 a = new _669_修剪二叉搜索树();
        GenergicTree g = new GenergicTree();
        Integer[] data = {45, 30, 46, 10, 36, null, 49, 8, 24, 34, 42, 48, null, 4, 9, 14, 25, 31, 35, 41, 43, 47, null, 0, 6, null, null, 11, 20, null, 28, null, 33, null, null, 37, null, null, 44, null, null, null, 1, 5, 7, null, 12, 19, 21, 26, 29, 32, null, null, 38, null, null, null, 3, null, null, null, null, null, 13, 18, null, null, 22, null, 27, null, null, null, null, null, 39, 2, null, null, null, 15, null, null, 23, null, null, null, 40, null, null, null, 16, null, null, null, null, null, 17}; //3,1,4,null,2[34] 3,2,4,1[11] 1,0,2[12]
        TreeNode node = g.levelOrderGenergic(data);
        TreeNode res = a.trimBST2(node, 32, 44);
        TreeNode res1 = a.trimBST(node, 32, 44);
        System.out.println(res);
        System.out.println(res1);
    }
}
