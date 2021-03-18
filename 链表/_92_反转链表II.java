package 链表;

public class _92_反转链表II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy, r = dummy, prev = dummy, next = null;
        int gap = right - left;
        while (right != 0) {
            if (left != 0) {
                prev = l;
                l = l.next;
                left--;
            }
            r = r.next;
            next = r.next;
            right--;
        }
        ListNode newHead = next;
        for (int i = 0; i <= gap; i++) {
            ListNode tmp = l.next;
            l.next = newHead;
            newHead = l;
            l = tmp;
        }
        prev.next = r;
        return dummy.next;
    }


    public static void main(String[] args) {
        _92_反转链表II a = new _92_反转链表II();
        int[] data = {1, 2, 3, 4, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.reverseBetween(node, 1, 5));
    }
}
