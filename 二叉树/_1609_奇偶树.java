package 二叉树;

import java.util.*;

public class _1609_奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val % 2 != 0;
        int floor = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int n = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int tempval = temp.val;
                int f = floor % 2;
                if (f == tempval % 2) return false;
                if (i != 0) {
                    if (f == 0) {
                        if (n >= tempval) return false;
                        n = tempval;
                    } else {
                        if (tempval >= n) return false;
                        n = tempval;
                    }
                }
                n = tempval;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            floor++;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17};
        List<Integer> list = new ArrayList(Arrays.asList(a));
        GenergicTree l = new GenergicTree();
        TreeNode node = l.levelOrderGenergic(list);
        _1609_奇偶树 b = new _1609_奇偶树();
        System.out.println(b.isEvenOddTree(node));
    }
}

class Test_1609 {
    List<Integer> list = new ArrayList();
    boolean flag = true;

    public boolean isEvenOddTree(TreeNode root) {
        levelsOrder(root, 0);
        return flag;
    }

    void levelsOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        int rootval = root.val;
        if (list.size() == level) {
            if (check(level, rootval, 0)) {
                flag = false;
                return;
            }
            list.add(rootval);
        } else {
            if (check(level, rootval, list.get(level))) {
                flag = false;
                return;
            }
            list.set(level, rootval);
        }
        levelsOrder(root.left, level + 1);
        levelsOrder(root.right, level + 1);
    }

    boolean check(int level, int rootval, int prev) {
        if (level % 2 == rootval % 2) {
            return true;
        }
        if (prev > 0) {
            if (level % 2 != 0 && prev <= rootval) {
                return true;
            } else if (level % 2 == 0 && prev >= rootval) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        GenergicTree g = new GenergicTree();
        Integer[] data = {1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2};
        Integer[] data2 = {5,4,2,3,3,7};
        Integer[] data1 = {15, 26, 1, 1, 5, 43, 47, 26, 24, 20, null, 18, 16, 12, 8, null, null, null, null, null, null, null, null, null, null, 21};
        TreeNode node = g.levelOrderGenergic(data2);
        System.out.println(new Test_1609().isEvenOddTree(node));
    }
}