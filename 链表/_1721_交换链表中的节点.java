package 链表;

public class _1721_交换链表中的节点 {
    public ListNode swapNodes(ListNode head, int k) {
        // 模拟指针，用来遍历链表
        ListNode cur = head;
        // 用来定位正数第k个节点
        ListNode first = head;
        // 用来定位倒数第k个节点
        ListNode last = head;
        // 用于节点的计数，和节点值的交换
        int count = 1;
        while (cur.next != null) {
            // 找到正数第k个节点
            if (count < k) {
                first = first.next;
                // 找到倒数第k个节点
            } else {
                last = last.next;
            }
            count++;
            cur = cur.next;
        }
        // 交换正数第k个节点和倒数第k个节点的值
        count = first.val;
        first.val = last.val;
        last.val = count;
        return head;
    }

    public static void main(String[] args) {
        _1721_交换链表中的节点 a = new _1721_交换链表中的节点();
        int[] data = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.swapNodes(node, 5));
    }
}
