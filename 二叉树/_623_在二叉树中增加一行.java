package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _623_在二叉树中增加一行 {
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode t = new TreeNode(v);
            if (d == 1) t.left = root;
            else t.right = root;
            return t;
        }
        if (root != null && d > 1) {
            root.left = addOneRow1(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow1(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }


    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        List<TreeNode> resList;
        resList = levelOrder(root, d);
        for (int i = 0; i < resList.size(); i++) {
            TreeNode node = resList.get(i);
            TreeNode leftnode = node.left;
            TreeNode rightnode = node.right;
            node.left = new TreeNode(v);
            node.left.left = leftnode;
            node.right = new TreeNode(v);
            node.right.right = rightnode;
        }
        return root;
    }

    public List<TreeNode> levelOrder(TreeNode root, int d) {
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> tmpList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                TreeNode tmp = queue.poll();
                if (count == d - 1) {
                    tmpList.add(tmp);
                }
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            count++;
        }
        return tmpList;
    }

    public static void main(String[] args) {
        _623_在二叉树中增加一行 a = new _623_在二叉树中增加一行();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root4.left = root2;
        root4.right = root6;
        root2.right = root3;
        root2.left = root1;
        root6.left = root5;
        TreeNode resnode = a.addOneRow(root4, 1, 1);
        System.out.println(resnode);
    }
}

class Test_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode t = new TreeNode(v);
            if (d == 1) {
                t.left = root;
            } else {
                t.right = root;
            }
            return t;
        }
        if (root != null && d > 1) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);// 1 代表左
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);// 0 代表右
        }
        return root;
    }
}

class Test_623_1 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode ans = new TreeNode(v);
            ans.left = root;
            return ans;
        }
        dfs(root, 1, d, v);

        return root;
    }

    private void dfs(TreeNode root, int dept, int d, int v) {
        if (root == null)
            return;
        if (dept + 1 == d) {
            TreeNode temp = root.left;
            root.left = new TreeNode(v);
            root.left.left = temp;
            temp = root.right;
            root.right = new TreeNode(v);
            root.right.right = temp;
            return;
        }
        dfs(root.left, dept + 1, d, v);
        dfs(root.right, dept + 1, d, v);
    }
}