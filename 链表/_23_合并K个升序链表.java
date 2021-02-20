package 链表;

import java.util.PriorityQueue;

public class _23_合并K个升序链表 {
    // 最小堆策略
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode();
        ListNode node = new ListNode();
        res.next = node;
        while (queue.size() != 0) {
            node.next = new ListNode(queue.poll());
            node = node.next;
        }
        return res.next.next;
    }


    public static void main(String[] args) {
        _23_合并K个升序链表 a = new _23_合并K个升序链表();
        GenergicListNode g = new GenergicListNode();
        ListNode node1 = g.getListNode(new int[]{1, 4, 5});
        ListNode node2 = g.getListNode(new int[]{1, 3, 4});
        ListNode node3 = g.getListNode(new int[]{2, 6});
        ListNode node4 = g.getListNode(new int[]{});
        ListNode[] nodes = new ListNode[]{node1, node2, node3, node4};
        System.out.println(a.mergeKLists(nodes));
    }

}
