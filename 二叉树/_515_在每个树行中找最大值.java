package 二叉树;

import java.util.*;

public class _515_在每个树行中找最大值 {

    /* public List<Integer> largestValues(TreeNode root) {
         if (root == null) return null;
         List<Integer> list = new ArrayList();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()) {
             int max = Integer.MIN_VALUE;
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                 TreeNode tmp = queue.poll();
                 if (tmp.val > max) {
                     max = tmp.val;
                 }
                 if (tmp.left != null) queue.add(tmp.left);
                 if (tmp.right != null) queue.add(tmp.right);
             }
             list.add(max);
         }
         return list;
     }
    public List<Integer> largestValues(List<TreeNode> nodes) {
        List<TreeNode> nodelist = new ArrayList();
        List<Integer> nodeval = new ArrayList();
        for (TreeNode t : nodes) {
            if (t == null) continue;
            nodeval.add(t.val);
            if (t.left != null) {
                nodelist.add(t.left);
            }
            if (t.right != null) {
                nodelist.add(t.right);
            }
        }
        if (nodeval.size() == 0) return list;
        list.add(Collections.max(nodeval));
        largestValues(nodelist);
        return list;
    }
*/
    public List<Integer> largestValues1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
            int count = q.size();
            int max = q.peek().val;
            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                if (node.val > max) max = node.val;
            }
            res.add(max);
        }
        return res;
    }

    public static void main(String[] args) {
        _515_在每个树行中找最大值 a = new _515_在每个树行中找最大值();
        Integer[] in = new Integer[]{0, -1, null};
        // Integer[] in = new Integer[]{1, 3, 2, 5, 3, null, 9};
        List<Integer> list = new ArrayList(Arrays.asList(in));
        GenergicTree l = new GenergicTree();
        TreeNode node = l.levelOrderGenergic(list);
        System.out.println(a.largestValues1(node));

    }
}

class Test_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    public void dfs(TreeNode node, List<Integer> list, int level) {
        if (node == null) return;
        if (list.size() == level) {
            list.add(node.val);
        } else {
            list.set(level, Math.max(list.get(level), node.val));
        }
        dfs(node.left, list, level + 1);
        dfs(node.right, list, level + 1);
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, 3, 4, 5, 3, null, 9};
        GenergicTree l = new GenergicTree();
        TreeNode node = l.levelOrderGenergic(data);
        System.out.println(new Test_515().largestValues(node));
    }
}
