package 二叉树;

import java.util.*;

public class _988_从叶结点开始的最小字符串_NotCheck {

    public String binaryTreePaths(TreeNode root) {
        LinkedList<List<Integer>> linked = new LinkedList();
        List<Integer> res = new ArrayList();
        if (root.left == null && root.right == null) {
            char r = (char) (root.val + 97);
            return String.valueOf(r);
        }

        getPath(root, new ArrayList(), linked);
        for (int i = 0; i < linked.size(); i++) {
            Collections.reverse(linked.get(i));
            List<Integer> l1 = linked.get(i);
            if (res.size() == 0) {
                res = l1;
                continue;
            } else {
                List<Integer> tmp = res;
                res = compare(l1, tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append((char) (i + 97));
        }
        return sb.toString();
    }

    private List<Integer> compare(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (l1.get(i) > l2.get(i)) {
                res = l2;
                return res;
            } else if (l1.get(i) < l2.get(i)) {
                res = l1;
                return res;
            } else {
                continue;
            }
        }
        if (res.size() == 0) return l1;
        return res;
    }

    private void getPath(TreeNode root, List<Integer> list, LinkedList<List<Integer>> linked) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            linked.add(list);
        } else {
            getPath(root.left, listadd(list), linked);
            getPath(root.right, listadd(list), linked);
        }
    }

    private List<Integer> listadd(List<Integer> list) {
        List<Integer> l = new ArrayList();
        l.addAll(list);
        return l;
    }

    public static void main(String[] args) {
        _988_从叶结点开始的最小字符串_NotCheck a = new _988_从叶结点开始的最小字符串_NotCheck();
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node25 = new TreeNode(25);

        node2.left = node2_1;
        node2.right = node1;
        node2_1.right = node1_1;
        node1.left = node0;
        node2_1.left = node0;
        System.out.println(a.binaryTreePaths(node2));
    }
}
