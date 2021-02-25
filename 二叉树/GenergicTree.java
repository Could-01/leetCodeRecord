package 二叉树;

import java.util.*;

// 针对LeetCode测试用例编程
public class GenergicTree {
       
    //层序遍历生成二叉树
    public TreeNode levelOrderGenergic(List<Integer> list) {
        int size = list.size();
        if (size < 1) return null;
        int index = 1;
        TreeNode root = new TreeNode(list.get(0));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node = null;
        Integer value = null;

        while (index != size) {
            node = queue.poll();
            if (index + 1 > size) break;
            value = list.get(index++);
            if (value != null) {
                TreeNode leftnode = new TreeNode(value);
                node.left = leftnode;
                queue.offer(leftnode);
            }
            if (index + 1 > size) break;
            value = list.get(index++);
            if (value != null) {
                TreeNode rightnode = new TreeNode(value);
                node.right = rightnode;
                queue.offer(rightnode);
            }
        }
        return root;
    }

    public TreeNode levelOrderGenergic(Integer[] list) {
        int size = list.length;
        if (size < 1) return null;
        int index = 1;
        TreeNode root = new TreeNode(list[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node = null;
        Integer value = null;

        while (index != size) {
            node = queue.poll();
            if (index + 1 > size) break;
            value = list[index++];
            if (value != null) {
                TreeNode leftnode = new TreeNode(value);
                node.left = leftnode;
                queue.offer(leftnode);
            }
            if (index + 1 > size) break;
            value = list[index++];
            if (value != null) {
                TreeNode rightnode = new TreeNode(value);
                node.right = rightnode;
                queue.offer(rightnode);
            }
        }
        return root;
    }

    public TreeNode levelOrderGenergic(int[] list) {
        int size = list.length;
        if (size < 1) return null;
        int index = 1;
        TreeNode root = new TreeNode(list[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node = null;
        Integer value = null;

        while (index != size) {
            node = queue.poll();
            if (index + 1 > size) break;
            value = list[index++];
            if (value != null) {
                TreeNode leftnode = new TreeNode(value);
                node.left = leftnode;
                queue.offer(leftnode);
            }
            if (index + 1 > size) break;
            value = list[index++];
            if (value != null) {
                TreeNode rightnode = new TreeNode(value);
                node.right = rightnode;
                queue.offer(rightnode);
            }
        }
        return root;
    }
}
