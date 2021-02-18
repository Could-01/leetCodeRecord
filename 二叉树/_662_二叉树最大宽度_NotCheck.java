package 二叉树;

import java.util.*;

//未做完
public class _662_二叉树最大宽度_NotCheck {

    public int widthOfBinaryTree(TreeNode root) {
        List<List<TreeNode>> list = levelOrder(root);
        int num = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            List<TreeNode> l = list.get(i);
            int left = 0, right = l.size() - 1;
            while (left != right) {
                if (l.get(left) == null) {
                    left++;
                }
                if (l.get(right) == null) {
                    right--;
                }
                if (l.get(left) != null && l.get(right) != null) {
                    num = right - left + 1 > num ? right - left + 1 : num;
                    break;
                }
            }
        }
        return num;
    }

    public List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> resList = new ArrayList<>();
        if (root == null) return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int x = queue.size();
            List<TreeNode> tmpList = new ArrayList<>();
            for (int i = 0; i < x; i++) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp);
                if (tmp != null) {
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
//                if (tmp.left != null) queue.add(tmp.left);
//                if (tmp.right != null) queue.add(tmp.right);
            }
            resList.add(tmpList);
        }
        return resList;
    }


    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 3, 2, 5, 3, null, 9};
        _662_二叉树最大宽度_NotCheck a = new _662_二叉树最大宽度_NotCheck();
        TreeNode node = g.levelOrderGenergic(data);
        System.out.println(a.widthOfBinaryTree(node));
    }
}

class Test_662 {
    private int maxW = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return maxW;
    }

    private void dfs(TreeNode r, int level, int index) {
        if (r == null) return;
        if (!map.containsKey(level))
            map.put(level, index);
        System.out.println(map);
        maxW = Math.max(maxW, index - map.get(level) + 1);
        dfs(r.left, level + 1, index * 2);
        System.out.println("开始r.right : " + (r.right == null ? "null" : r.right.val));
        dfs(r.right, level + 1, index * 2 + 1);
    }

    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 3, 2, 5, null, null, 9, 6, null, null, 7};
        TreeNode node = g.levelOrderGenergic(data);
        Test_662 a = new Test_662();
        System.out.println(a.widthOfBinaryTree(node));
    }

}

class Test_662_2 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(1);
        while (queue.size() > 0) {
            int count = queue.size();
            int left = index.peek();
            System.out.println("left = "+left+", count = "+count);
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                int i = index.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    index.offer(i * 2);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    index.offer(i * 2 + 1);
                }
                if (count == 0)
                    result = Math.max(result, 1 + i - left);
                System.out.println("" + result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 3, 2, 5, null, null, 9, 6, null, null, 7};
        TreeNode node = g.levelOrderGenergic(data);
        Test_662_2 a = new Test_662_2();
        System.out.println(a.widthOfBinaryTree(node));
    }
}