package 链表;


public class _剑指_Offer22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
            if (count >= k - 1) {
                pre = pre.next;
            }
        }
        return pre;
    }
}
