package 二叉树;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _98_验证二叉搜索树 {
    List<Integer> list = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        inOrder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }


    public void inOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curTreeNode = root;
        while (!s.isEmpty() || curTreeNode != null) {
            while (curTreeNode != null) {
                s.push(curTreeNode);
                curTreeNode = curTreeNode.left;
            }
            curTreeNode = s.pop();
            list.add(curTreeNode.val);
            curTreeNode = curTreeNode.right;
        }
    }

    public static void main(String[] args) {
        _98_验证二叉搜索树 a = new _98_验证二叉搜索树();
        Solution1 s = new Solution1();
        GenergicTree g = new GenergicTree();
        Integer[] data1 = {5, 1, 4, null, null, 3, 6};
        Integer[] data = {4, 2, 6, 1, 3, 5, 7};
        TreeNode root1 = g.levelOrderGenergic(data);
        System.out.print(s.isValidBST(root1));
    }
}

class Solution1 {
    //使用了中序遍历，使得树节点值由小到大排列，如果不对，则报错。

    //什么时候结束？ 节点为空时结束。
    //每层干什么？ 如果情况不对，则报false。
    //给下一层什么？ pre的值。
    //着重于返回false，而不是true。false
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}