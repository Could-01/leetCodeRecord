package 二叉树;

import java.lang.reflect.Array;
import java.util.*;

public class _1305_两棵二叉搜索树中的所有元素 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = InOrder(root1, new ArrayList<>());
        List<Integer> list2 = InOrder(root2, new ArrayList<>());
        if (list1.size() == 0) {
            return list2;
        } else if (list2.size() == 0) {
            return list1;
        }
        List<Integer> res = new ArrayList();
        int i = 0, j = 0;
        while (i != list1.size() && j != list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            if (num1 <= num2) {
                res.add(num1);
                i++;
            } else {
                res.add(num2);
                j++;
            }
            if (i == list1.size()) {
                for (int c = j; c < list2.size(); c++) {
                    res.add(list2.get(c));
                }
            } else if (j == list2.size()) {
                for (int c = i; c < list1.size(); c++) {
                    res.add(list1.get(c));
                }
            }
        }
        return res;
    }

    public static List<Integer> inOrderFast(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode curTreeNode = root;
        while (!s.isEmpty() || curTreeNode != null) {
            // 入栈所有左节点并输出左节点
            while (curTreeNode != null) {
                s.push(curTreeNode);
                curTreeNode = curTreeNode.left;
            }
            // 弹出左节点
            curTreeNode = s.pop();
            list.add(curTreeNode.val);
            // 弹出后，指向当前节点的右节点
            curTreeNode = curTreeNode.right;
        }
        return list;
    }


    List<Integer> InOrder(TreeNode node, List<Integer> queue) {
        if (node == null) return null;
        InOrder(node.left, queue);
        queue.add(node.val);
        InOrder(node.right, queue);
        return queue;
    }

    public static void main(String[] args) {
        _1305_两棵二叉搜索树中的所有元素 a = new _1305_两棵二叉搜索树中的所有元素();
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        TreeNode node0 = new TreeNode(0);
        TreeNode node7 = new TreeNode(2);
        node2.left = node1;
        node2.right = node3;

        node5.left = node4;
        node5.right = node6;
        node4.left = node0;
        node4.right = node7;
        System.out.println(a.getAllElements(node2, node5));
    }
}

class Test_1305 {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue1 = InOrder(root1, new LinkedList<>());
        Queue<Integer> queue2 = InOrder(root2, new LinkedList<>());
        if (queue1 == null && queue2 == null) return res;
        if (queue1 == null) {
            while (queue2.size() != 0) {
                int v = queue2.poll();
                res.add(v);
            }
        }
        if (queue2 == null) {
            while (queue1.size() != 0) {
                int v = queue1.poll();
                res.add(v);
            }
        }

        int len1 = queue1.size();
        int len2 = queue2.size();
        while (res.size() < len1 + len2) {
            if (queue1.size() == 0) {
                while (queue2.size() != 0) {
                    int v = queue2.poll();
                    res.add(v);
                }
                break;
            }
            if (queue2.size() == 0) {
                while (queue1.size() != 0) {
                    int v = queue1.poll();
                    res.add(v);
                }
                break;
            }
            if (queue1.peek() < queue2.peek()) {
                int v = queue1.poll();
                res.add(v);
            } else {
                int v = queue2.poll();
                res.add(v);
            }
        }
        return res;
    }

    Queue<Integer> InOrder(TreeNode node, Queue<Integer> queue) {
        if (node == null) return null;
        InOrder(node.left, queue);
        queue.offer(node.val);
        InOrder(node.right, queue);
        return queue;
    }

    public static void main(String[] args) {
        Test_1305 a = new Test_1305();
        Integer[] data = {};
        Integer[] data1 = {5, 1, 7, 2, 0};
        TreeNode node = new GenergicTree().levelOrderGenergic(data);
        TreeNode node1 = new GenergicTree().levelOrderGenergic(data1);
        System.out.println(a.getAllElements(node, node1));
    }
}