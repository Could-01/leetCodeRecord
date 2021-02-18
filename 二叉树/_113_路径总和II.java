package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _113_路径总和II {
    /*public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return null;
        getPath1(root, new ArrayList(), res, targetSum);
        return res;
    }


    void getPath1(TreeNode root, List<Integer> list, List<List<Integer>> linked, int targetSum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sumNode(list) == targetSum) {
                linked.add(list);
            }
        } else {
            getPath1(root.left, new ArrayList(list), linked, targetSum);
            getPath1(root.right, new ArrayList(list), linked, targetSum);
        }
    }*/
    List<List<Integer>> res = new ArrayList();//全局变量来获取所有的结果路径

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> temp = new LinkedList<>();
        helper(root, sum, temp);
        return res;
    }

    public void helper(TreeNode node, int sum, LinkedList<Integer> temp) {
        if (node == null) return;
        temp.addLast(node.val);
        if (node.left == null && node.right == null && sum == node.val) res.add(new ArrayList(temp));
        helper(node.left, sum - node.val, temp);
        helper(node.right, sum - node.val, temp);
        temp.removeLast();
    }


    public static void main(String[] args) {
        _113_路径总和II a = new _113_路径总和II();
        GenergicTree g = new GenergicTree();
        Integer[] data = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.pathSum(node, 22));
    }
}
