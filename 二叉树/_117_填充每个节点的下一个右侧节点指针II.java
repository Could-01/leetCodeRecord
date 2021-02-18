package 二叉树;

import java.util.*;

public class _117_填充每个节点的下一个右侧节点指针II {


    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int x = queue.size();
            Node e = null;
            for (int i = 0; i < x; i++) {
                Node tmp = queue.poll();
                if (i != 0) {
                    e.next = tmp;
                }
                e = tmp;
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        _117_填充每个节点的下一个右侧节点指针II c = new _117_填充每个节点的下一个右侧节点指针II();
        c.connect1(node1);
    }

/*
    //用时最短
    Node last = null, nextStart = null;

    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
*/


    //占用空间最少
    public Node connect1(Node root) {
        if (root == null) return null;
        Node NextNode = root.next;
        System.out.println(root.val + (NextNode == null ? "  空" : "  NextNode.val : " + NextNode.val));
        while (NextNode != null) {
            if (NextNode.left != null) {
                NextNode = NextNode.left;
                break;
            }
            if (NextNode.right != null) {
                NextNode = NextNode.right;
                break;
            }
            NextNode = NextNode.next;
        }
        if (root.right != null) root.right.next = NextNode;
        if (root.left != null) root.left.next = root.right != null ? root.right : NextNode;
        connect1(root.right);
        connect1(root.left);
        return root;
    }


    public Node connect2(Node root) {
        if (root == null) return null;
        Node nextNode = root.next;
        //说明到 2 了
        while (nextNode != null) {
            if (nextNode.left != null) {
                nextNode = nextNode.left;
            }

            if (nextNode.right != null) {
                nextNode = nextNode.right;
            }
            nextNode = nextNode.next;
            //到最右侧去
        }

        if (root.right != null) root.right.next = nextNode;
        if (root.left != null) root.left.next = root.right != null ? root.right : nextNode;
        connect1(root.right);
        connect1(root.left);
        return root;

    }


}