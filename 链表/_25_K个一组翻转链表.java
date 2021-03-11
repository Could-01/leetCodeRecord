package 链表;

public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        int len = 0;
        ListNode h = head;
        while (h != null) {
            h = h.next;
            len++;
        }
        if (k > len) return head;
        h = head;
        ListNode p1 = null, p2 = head, p3 = head;
        for (int i = 0; i < k; i++) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        h.next = reverseKGroup(p2, k);
        return p1;
    }

    public static void main(String[] args) {
        _25_K个一组翻转链表 a = new _25_K个一组翻转链表();
        int[] data = {1, 2, 3, 4, 5};
        ListNode node = new GenergicListNode().getListNode(data);
        System.out.println(a.reverseKGroup(node, 3));
    }

}
